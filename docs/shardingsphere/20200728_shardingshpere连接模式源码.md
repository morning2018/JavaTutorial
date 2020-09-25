# 连接模式
- 内存限制模式
- 连接限制模式
# 代码跟踪

- 理论基础
基于jdbc的基本执行流程：
~~~
datasource -> connection -> preparedStatement -> execute -> resultSet
~~~

- ShardingPreparedStatement
```java
@Override
    public ResultSet executeQuery() throws SQLException {
        ResultSet result;
        try {
            clearPrevious();
            sqlRoute();
            // 初始化preparedStatementExecutor并执行SQL
            initPreparedStatementExecutor();
            // 归并引擎进行归并结果集
            MergeEngine mergeEngine = MergeEngineFactory.newInstance(connection.getShardingContext().getDatabaseType(), connection.getShardingContext().getShardingRule(),
                    routeResult.getSqlStatement(), connection.getShardingContext().getMetaData().getTable(), preparedStatementExecutor.executeQuery());
            result = new ShardingResultSet(preparedStatementExecutor.getResultSets(), mergeEngine.merge(), this);
        } finally {
            clearBatch();
        }
        currentResultSet = result;
        return result;
    }
```
```java
private void initPreparedStatementExecutor() throws SQLException {
       preparedStatementExecutor.init(routeResult);
       setParametersForStatements();
}
```
- PreparedStatementExecutor
```java
/**
    * Initialize executor.
    *
    * @param routeResult route result
    * @throws SQLException SQL exception
    */
   public void init(final SQLRouteResult routeResult) throws SQLException {
       getExecuteGroups().addAll(obtainExecuteGroups(routeResult.getRouteUnits()));
       cacheStatements();
   }
```
```java
private Collection<ShardingExecuteGroup<StatementExecuteUnit>> obtainExecuteGroups(final Collection<RouteUnit> routeUnits) throws SQLException {
        return getSqlExecutePrepareTemplate().getExecuteUnitGroups(routeUnits, new SQLExecutePrepareCallback() {

            @Override
            public List<Connection> getConnections(final ConnectionMode connectionMode, final String dataSourceName, final int connectionSize) throws SQLException {
                return PreparedStatementExecutor.super.getConnection().getConnections(connectionMode, dataSourceName, connectionSize);
            }

            @Override
            public StatementExecuteUnit createStatementExecuteUnit(final Connection connection, final RouteUnit routeUnit, final ConnectionMode connectionMode) throws SQLException {
                return new StatementExecuteUnit(routeUnit, createPreparedStatement(connection, routeUnit.getSqlUnit().getSql()), connectionMode);
            }
        });
    }
```
- SQLExecutePrepareTemplate
```java
/**
   * Get execute unit groups.
   *
   * @param routeUnits route units
   * @param callback SQL execute prepare callback
   * @return statement execute unit groups
   * @throws SQLException SQL exception
   */
  public Collection<ShardingExecuteGroup<StatementExecuteUnit>> getExecuteUnitGroups(final Collection<RouteUnit> routeUnits, final SQLExecutePrepareCallback callback) throws SQLException {
      return getSynchronizedExecuteUnitGroups(routeUnits, callback);
  }
```
```java
private Collection<ShardingExecuteGroup<StatementExecuteUnit>> getSynchronizedExecuteUnitGroups(
           final Collection<RouteUnit> routeUnits, final SQLExecutePrepareCallback callback) throws SQLException {
       Map<String, List<SQLUnit>> sqlUnitGroups = getSQLUnitGroups(routeUnits);
       Collection<ShardingExecuteGroup<StatementExecuteUnit>> result = new LinkedList<>();
       for (Entry<String, List<SQLUnit>> entry : sqlUnitGroups.entrySet()) {
           result.addAll(getSQLExecuteGroups(entry.getKey(), entry.getValue(), callback));
       }
       return result;
   }
```
```java
private List<ShardingExecuteGroup<StatementExecuteUnit>> getSQLExecuteGroups(
          final String dataSourceName, final List<SQLUnit> sqlUnits, final SQLExecutePrepareCallback callback) throws SQLException {
      List<ShardingExecuteGroup<StatementExecuteUnit>> result = new LinkedList<>();
      int desiredPartitionSize = Math.max(0 == sqlUnits.size() % maxConnectionsSizePerQuery ? sqlUnits.size() / maxConnectionsSizePerQuery : sqlUnits.size() / maxConnectionsSizePerQuery + 1, 1);
      List<List<SQLUnit>> sqlUnitPartitions = Lists.partition(sqlUnits, desiredPartitionSize);
      ConnectionMode connectionMode = maxConnectionsSizePerQuery < sqlUnits.size() ? ConnectionMode.CONNECTION_STRICTLY : ConnectionMode.MEMORY_STRICTLY;
      List<Connection> connections = callback.getConnections(connectionMode, dataSourceName, sqlUnitPartitions.size());
      int count = 0;
      for (List<SQLUnit> each : sqlUnitPartitions) {
          result.add(getSQLExecuteGroup(connectionMode, connections.get(count++), dataSourceName, each, callback));
      }
      return result;
  }
```
最终确定的算法为：
```java
        ConnectionMode connectionMode = maxConnectionsSizePerQuery < sqlUnits.size() ? ConnectionMode.CONNECTION_STRICTLY : ConnectionMode.MEMORY_STRICTLY;

```
说明：
1. 通过 maxConnectionsSizePerQuery来控制连接模式，当maxConnectionsSizePerQuery小于本数据源执行单元时，选择连接限制模式，反之，则选择内存限制模式

## 连接模式对返回结果集的影响

- PreparedStatementExecutor执行sql后会基于连接模式返回不同的结果集
```java
private QueryResult getQueryResult(final StatementExecuteUnit statementExecuteUnit) throws SQLException {
     PreparedStatement preparedStatement = (PreparedStatement) statementExecuteUnit.getStatement();
     ResultSet resultSet = preparedStatement.executeQuery();
     getResultSets().add(resultSet);
     return ConnectionMode.MEMORY_STRICTLY == statementExecuteUnit.getConnectionMode() ? new StreamQueryResult(resultSet) : new MemoryQueryResult(resultSet);
 }
```


# 结论
连接数消耗计算原理： 

max.connections.size.per.query控制真实的连接数的消耗：

 max.connections.size.per.query会影响连接模式，算法如下：

ConnectionMode connectionMode = maxConnectionsSizePerQuery < sqlUnits.size() ? ConnectionMode.CONNECTION_STRICTLY : ConnectionMode.MEMORY_STRICTLY;

 max.connections.size.per.query和sqlUnits（单数据源的真实sql数）会影响连接数，算法：

 int desiredPartitionSize = Math.max(0 == sqlUnits.size() % maxConnectionsSizePerQuery ? sqlUnits.size() / maxConnectionsSizePerQuery : sqlUnits.size() / maxConnectionsSizePerQuery + 1, 1)

示例：

| maxConnectionsSizePerQuery | dsSize | tableSizePerDs | connectionMode      | 实际连接数 |
| -------------------------- | ------ | -------------- | ------------------- | ---------- |
| 200                        | 24     | 32             | MEMORY_STRICTLY     |            |
| 1                          | 24     | 32             | CONNECTION_STRICTLY | 1          |
|                            |        |                |                     |            |



connectionMode 



目前测试了 max.connections.size.per.query=200，24分库32分表，能支持，但是查询性能很慢





