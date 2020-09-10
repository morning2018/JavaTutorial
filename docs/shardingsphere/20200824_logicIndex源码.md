# zdaas-jdbc针对PG/Oracle数据库分片规则需要配置LogicIndex,mysql不需要配置



## 配置验证

pg数据库只有配置了logicIndex才能进行索引删除，否则删除失败。

```yaml
shardingTableRule:
  templates:
    sdst-1: #自定义分片规则模板，名为sdst-1
      actualDataNodes: demo_ds_\${0..${DB_NUM - 1}}.${TABLE}\${0..${DB_NUM - 1}}
      databaseStrategy:
        inline:
          shardingColumn: ${DB_COLUMN}
          algorithmExpression: demo_ds_\${${DB_COLUMN} % ${DB_NUM}}
      tableStrategy:
        inline:
          shardingColumn: ${TB_COLUMN}
          algorithmExpression: ${TABLE}\${${TB_COLUMN} % ${TB_NUM}}
      logicIndex: order_index # pg数据库需要配置逻辑索引才能进行索引删除
    sdst-2:
      actualDataNodes: demo_ds_\${0..${DB_NUM - 1}}.${TABLE}\${0..${DB_NUM - 1}}
      databaseStrategy:
        inline:
          shardingColumn: ${DB_COLUMN}
          algorithmExpression: demo_ds_\${${DB_COLUMN} % ${DB_NUM}}
  usages:
    sdst-1:
      - t_order|user_id|order_id   #表名|分库键|分表键
      - t_order_item|user_id|order_id
    sdst-2:
      - type_table|id
```

## 对比分析：

PG/Oracle数据库：

```sql
DROP INDEX order_index;
//分片规则-> 逻辑索引-> 逻辑表 -> 进行路由解析 -> 获取到真实表 -> 重写引擎基于规则重写DDL->执行真实sql
```

mysql数据库：

```sql
DROP INDEX  order_index on t_order;
// 逻辑表 -> 进行路由解析 -> 获取到真实表 -> 重写引擎基于规则重写DDL->执行真实sql
```



## 源码分析：

测试用例：

```java
String sql  = "DROP INDEX  order_index";
jdbcTemplate.execute(sql);
```

执行ShardingStatement.execute,跟踪到sqlRoute(sql)进行路由解析：

```java

public boolean execute(final String sql) throws SQLException {
        try {
            clearPrevious();
            // TODO sqlRoute(sql)
            sqlRoute(sql);
            initStatementExecutor();
            return statementExecutor.execute();
        }
        finally {
            if (routeResult != null) {
                refreshTableMetaData(connection.getShardingContext(), routeResult.getSqlStatement());
            }
            currentResultSet = null;
        }
    }
```

执行StatementRoutingEngine.route进行路由引擎处理：

```java
/**
 * SQL route.
 *
 * @param logicSQL logic SQL
 * @return route result
 */
public SQLRouteResult route(final String logicSQL) {
    SQLStatement sqlStatement = shardingRouter.parse(logicSQL, false);
    // TODO shardingRouter.route(logicSQL, Collections.emptyList(), sqlStatement)
    return masterSlaveRouter.route(shardingRouter.route(logicSQL, Collections.emptyList(), sqlStatement));
}
```

执行ShardingRouterProxy.route,进行分片路由处理：

```java
@Override
public SQLRouteResult route(final String logicSQL, final List<Object> parameters, final SQLStatement sqlStatement) {
    if (SqlHintTokenizer.isSqlHintBegin(logicSQL)) {
        return this.sqlHintRoute(logicSQL, parameters, sqlStatement);
    }
    else {
        // TODO target.route(logicSQL, parameters, sqlStatement)
        return target.route(logicSQL, parameters, sqlStatement);
    }

}
```

执行ParsingSQLRouter.route,进行SQL解析路由:

```java
@Override
public SQLRouteResult route(final String logicSQL, final List<Object> parameters, final SQLStatement sqlStatement) {
    Optional<GeneratedKey> generatedKey = sqlStatement instanceof InsertStatement
        ? getGenerateKey(shardingRule, (InsertStatement) sqlStatement, parameters)
        : Optional.<GeneratedKey> absent();
    SQLRouteResult result = new SQLRouteResult(sqlStatement, generatedKey.orNull());
    ShardingConditions shardingConditions = OptimizeEngineFactory
        .newInstance(shardingRule, sqlStatement, parameters, generatedKey.orNull()).optimize();
    if (generatedKey.isPresent()) {
        setGeneratedKeys(result, generatedKey.get());
    }
    // fixed by Eric #issue16
    if (sqlStatement instanceof SelectStatement && !sqlStatement.getTables().isEmpty()
        && ((SelectStatement) sqlStatement).getSubQueryConditions().size() > 1
        && containConditionsOfSubQueryConditions(((SelectStatement) sqlStatement).getSubQueryConditions())) {
        mergeShardingValueForSubQuery(sqlStatement.getConditions(), shardingConditions);
    }
    RoutingResult routingResult = RoutingEngineFactory
        .newInstance(shardingRule, shardingMetaData.getDataSource(), sqlStatement, shardingConditions).route();
    SQLRewriteEngine rewriteEngine = new SQLRewriteEngine(shardingRule, logicSQL, databaseType, sqlStatement,
        shardingConditions, parameters);
    if (sqlStatement instanceof SelectStatement && null != ((SelectStatement) sqlStatement).getLimit()) {
        if (!routingResult.isSingleRouting()) {
            processLimit(parameters, (SelectStatement) sqlStatement);
        }
    }
    SQLBuilder sqlBuilder = rewriteEngine.rewrite(routingResult.isSingleRouting());
    for (TableUnit each : routingResult.getTableUnits().getTableUnits()) {
        result.getRouteUnits().add(new RouteUnit(each.getDataSourceName(),
            rewriteEngine.generateSQL(each, sqlBuilder, shardingMetaData.getDataSource())));
    }
    if (showSQL) {
        SQLLogger.logSQL(logicSQL, sqlStatement, result.getRouteUnits());
    }
    return result;
}
```

执行SQLRewriteEngine.generateSQL,至此通过逻辑表,获取真实的执行SQL

```java
/**
 * Generate SQL string.
 * 
 * @param tableUnit route table unit
 * @param sqlBuilder SQL builder
 * @param shardingDataSourceMetaData sharding data source meta data
 * @return SQL unit
 */
public SQLUnit generateSQL(final TableUnit tableUnit, final SQLBuilder sqlBuilder, final ShardingDataSourceMetaData shardingDataSourceMetaData) {
    return sqlBuilder.toSQL(tableUnit, getTableTokens(tableUnit), shardingRule, shardingDataSourceMetaData);
}
```