# 1. 概述
- 什么是shardingsphere?
- 为什么要用shardingsphere？
# 2. 概念
## 2.1 SQL相关概念
- SQL Type
  - DML(Data Manipulation Language)，例如:insert,update,delete等
  - DDL(Data Definition Language)，例如：create ,drop ,alter,trucate等
  - DQL(Data Query Language)，例如：select等
  - DCL(Database Control Language)，例如：Grant,Revoke等
  - TCL(Transaction Control Language)，例如：Set,Begin,Commit,rollback,savepoint等
  - DAL(Database administrator Language)，例如：DESCRIBE,explain，use等
- 逻辑表
  - 例如：t_order是t_order_0、t_order_1、t_order_2等的逻辑表。
- 真实表
  - t_order_0是真实存在的表
- 数据节点
  - 数据源名称+数据表，ds_0.t_order_0
- 绑定表
  - 分片规则一致的主表和子表。
- 广播表
  - 指所有的数据源中都存在的表。一般是数据量不大的表，例如：字典表。
## 2.2 分片
- 分片键
  - 用于分片的数据库表字段。例如订单使用主键进行取模分片，那么订单主键就是分片键。
- 分片算法（4种）
  - 精确分片算法
    - PreciseShardingAlgorithm
    - StandardShardingStrategy
  - 范围分片算法
    - RangeShardingAlgorithm
    - StandardShardingStrategy
  - 复合分片算法
    - ComplexKeysShardingAlgorithm
    - ComplexShardingStrategy
  - Hint分片算法
    - HintShardingAlgorithm
    - HintShardingStrategy
- 分片策略（5种）
  - 标准分片策略-StandardShardingStrategy
    - 提供对SQL语句中的=、>、<、>=、<=、in、BETWEEN AND的分片操作支持
    - 只支持单分片键
  - 复合分片策略-ComplexShardingStrategy
    - 提供对SQL语句中的 =, >, <, >=, <=, IN 和 BETWEEN AND 的分片操作支持
    - 支持多分片键
    - 分片策略由开发者实现，灵活度大
  - 行表达式分片策略-InlineShardingStrategy
    - 使用Groovy的表达式，提供对SQL语句中的 = 和 IN 的分片操作支持
    - 只支持单分片键
  - Hint分片策略-HintShardingStrategy
    - 通过 Hint 指定分片值而非从 SQL 中提取分片值的方式进行分片的策略
  - 不分片策略-NoneShardingStrategy
## 2.3 配置
- 分片规则
- 数据源配置
  - 真实的数据源列表
  - 验证//TODO
- 表配置
  - 逻辑表名称、数据节点、分表规则
  - 验证//TODO
- 数据节点配置(配置逻辑表与真实表的映射关系)
  - 均匀分布
    - 数据表在数据源种呈均匀分布态势。
    - 验证//TODO
  - 自定义分布
    - 数据表在数据源种呈特定自定义规则分布。
    - 验证//TODO
- 分片策略配置
  - 数据源分片-DatabaseShardingStrategy
    - 验证//TODO
  - 表分片-TableShardingStrategy
    - 验证//TODO
- 自增主键生成策略
  - 通过客户端的主键生成策略，替换数据库原生的主键生成方式。
## 2.4 行表达式
- 实现动机
  - 简化配置（使用表达式代替硬编码）
  - 一体化
- 语法说明
  - ${ expression } 或 $->{ expression }，内容使用groovy语言
  - 验证//TODO
- 配置数据节点
  - 均匀分布节点
    ```
    db${0..1}.t_order${0..1}
    ```
  - 自定义数据节点
    ```
    db0.t_order${0..1},db1.t_order${2..4}
    ```
  - 有前缀的数据节点
    ```
    db${0..1}.t_order_0${0..9},db${0..1}.t_order_${10..20}
    ```
 - 配置分片算法
   - 例如:取余配置,设置为10个库
   ```
   ds${id % 10}
   ```
## 2.5 分布式主键
- 内置UUID
  - UUID.randomUUID()
  - 无序
- 内置SNOWFLAKE
  - 2016年11月1日零点开始，可以使用到2086年
  - 时钟回拨问题需要设置时钟回拨秒数
- 思考：可以使用redis提供分布式主键
## 2.6 强制分片路由
- 实现动机
  - SQL携带分片条件，无侵入的自动解析
  - SQL不携带分片条件，基于Hint注入分片条件
- 实现机制
  - 基于ThreadLocal通过编程式向HintManager中添加分片条件，线程内生效
  - 计划基于SQL的hint方式注入分片条件
  - 指定了强制分片路由则会无视原有的分片逻辑
# 3. 数据分片引擎
## 3.1 解析引擎
### 3.1.1 抽象语法树
- 词法解析
- 语法解析
- 支持多种SQL方言
### 3.1.2 SQL解析
- 第一代：Druid实现，性能较好
- 第二代:自研，采用"半理解"方式，不需要做全部的SQL解析，性能进一步提升
- 第三代：ANTLR实现，还在替换进行中(202007)，增加SQL的兼容性，性能比第二代降低了3-10倍，建议采用PreparedStatement进行缓存加速。
## 3.2 路由引擎
### 3.2.1 分片路由（3种）
- 直接路由
  - 路由条件苛刻：通过hint进行分片，只能分库不能分表
  - 优点：
     1. 兼容性好，可以执行包括子查询，自定义函数，等复杂情况的任意SQL.
     2. 适用于分片键不在SQL中的场景。
- 标准路由
  - 推荐的路由规则
  - 适用于不包含关联查询或者仅包含绑定表之间的关联查询SQL
  - 执行时真实SQL可能是一条也可能是多条
- 笛卡尔路由
  - 最复杂的路由，查询性能较低，需谨慎使用。
  - 无法根据绑定表关系定位分片规则，因此非绑定表之间的关联查询需要拆解为笛卡尔积组合执行。
### 3.2.2 广播路由（5种）
- 适用场景：对于不携带分片键的SQL
- 全库表路由
  - 适用场景：与逻辑表相关的所有真实表的操作，包括：不带分片键的DQL和DML以及DDL等。
  - 验证//TODO
- 全库路由
  - 适用场景：用于处理对数据库的操作，包括用于库设置的set类型的数据库管理命令，以及TCL相关的事务控制语句。会根据逻辑库的名字遍历所有符合名字匹配的真实库。
  - 验证//TODO
- 全实例路由
  - 适用场景：用于DCL操作，授权语句针对的是数据库的实例。无论一个实例中包含多少个schema，每个数据库的实例只执行一次。
  - 验证//TODO
- 单播路由
  - 适用场景：用于获取某一真实表信息的场景，它仅需要从任意库中的任意真实表中获取数据即可。
  - 验证//TODO
- 阻断路由
  - 适用场景：屏蔽SQL对数据库的操作。
  - 验证：//TODO
## 3.3 改写引擎
### 3.3.1 正确性改写
- 标识符改写
  - 包括表名称，索引名称，以及Schema名称
- 补列
  - GroupBy和OrderBy可能需要补列
  - AVG聚合函数可能需要补列
- 分页修正
- 批量拆分
### 3.3.2 优化改写
- 单节点优化
  - 路由至单节点的SQL，无需进行优化。
- 流式归并优化
  - 它仅为包含GROUP BY的SQL增加ORDER BY以及和分组项相同的排序项和排序顺序，用于将内存归并转化为流式归并

## 3.4 执行引擎
- 作用：将路由和改写完成之后的真实SQL安全且高效的发送到底层数据源执行。目标是自动化的平衡资源控制与执行效率。
### 3.4.1 连接模式
- 内存限制模式
  - 对一次操作的数据库连接数不做限制
  - 通过多线程的方式并发执行，以达成执行效率最大化
  - 流式归并
  - 适合OLAP操作
- 连接限制模式
  - 严格控制一次操作所耗费的数据库连接数量
  - 针对一次操作对应的数据库，每个数据库只会创建一个数据库连接，进行串行操作
  - 内存归并
  - 适合OLTP操作
### 3.4.2 自动化执行引擎
- 准备阶段
  - 结果集分组
  - 执行单元创建
- 执行阶段
  - 分组执行
  - 归并结果集生成

## 3.5 归并引擎
- 遍历归并
- 排序归并
- 分组归并
- 聚合归并
- 分页归并

# 4. 使用规范
## 4.1 SQL
- 支持项
  - 路由至单节点
  - 路由至多节点
- 不支持项
  - 路由至多数据点
  - 对分片键进行操作
## 4.2 分页
- 能力范围：支持mysql、postgreSQL、Oracle，支持部分的SQLServer
- 分页性能
  - 性能瓶颈
    - 查询偏移量过大会导致性能低下
  - ShardingSphere的优化
    - 流式处理+归并排序的方式来规避内存的过量占用。
    - ShardingSphere对仅落至单分片的查询进行进一步优化，并未改写SQL
- 分页优化方案
- 分页子查询
## 4.3 解析器
- 特定SQL方言解析器
  - PostgreSQL解析器
  - MySQL解析器（MySQL,H2,MariaDB）
  - Oracle解析器
  - SQLServer解析器
- 默认SQL方言解析器
  - 默认采用SQL92标准,如：SQLite,Sybase,DB2,Infomix等

# 5. 分布式事务
## 5.1 核心概念
### 5.1.1 XA两阶段提交
- 概念
  - AP(Application Program)
  - TM(Transaction Manager)
  - RM(Resource Manager)
- Java通过JTA接口实现XA模型
### 5.1.2 Seata柔性事务
- 概念
  - TM(Transaction Manager)
  - RM(Resource Manager)
  - TC(Transaction Coordinator)
- 生命周期
  - 1. TM 要求 TC 开始一个全新的全局事务。TC 生成一个代表该全局事务的 XID。
  - 2. XID 贯穿于微服务的整个调用链
  - 3. 作为该 XID 对应到的 TC 下的全局事务的一部分，RM 注册本地事务。
  - 4. TM 要求 TC 提交或回滚 XID 对应的全局事务。
  - 5. TC 驱动 XID 对应的全局事务下的所有分支事务完成提交或回滚。
## 5.2 原理
### 5.2.1 XA两阶段提交
- XAShardingTransactionManager：分布式事务XA的实现类
#### 5.2.1.1 开启全局事务
- 收到接入端的 set autoCommit=0 时，XAShardingTransactionManager 将调用具体的 XA 事务管理器开启 XA 全局事务，以 XID 的形式进行标记
#### 5.2.1.2 执行真实分片SQL
#### 5.2.1.3 提交或回滚事务
### 5.2.2 Seata柔性事务
#### 5.2.2.1 引擎初始化
#### 5.2.2.2 开启全局事务
#### 5.2.2.3 执行真实分片SQL
#### 5.2.2.4 提交或回滚事务
## 5.3 规范
### 5.3.1 本地事务
- 支持项
  - 完全支持分跨库事务，如:仅分表，或分库但是路由的数据在单库中。
- 不支持项
  - 不支持因网络、硬件异常导致的跨库事务。
### 5.3.2 XA两阶段提交
- 支持项
  - 支持数据分片后的跨库事务
  - 两阶段提交保证操作的原子性和数据的强一致性
  - 服务宕机重启后，提交/回滚中的事务可自动恢复
  - 支持同时使用 XA 和非 XA 的连接池
- 不持支项
  - 服务宕机后，在其它机器上恢复提交/回滚中的数据
### 5.3.2 Seata柔性事务
- 支持项
  - 支持数据分片后的跨库事务
  - 支持RC隔离级别
  - 通过undo快照进行事务回滚
  - 支持服务宕机后的，自动恢复提交中的事务
- 不支持项
  - 不支持除RC之外的隔离级别
- 待优化项
  - Apache ShardingSphere 和 Seata 重复 SQL 解析

# 6. 读写分离
## 6.1 概念
- 主库
  - 写相关操作使用的数据库，目前支持单主库
- 从库
  - 读相关操作使用的数据库，支持多从库
- 主从同步
  - 将主数据异步的同步到从库的操作，异步操作会导致短时间内的数据不一致性。
- 负载均衡策略
  - 针对读请求可以基于负载策略进行选择不同的从库
## 6.2 规范
- 支持项
  - 验证//TODO
- 不支持项
  - 验证//TODO
# 7. 分布式治理
## 7.1 治理
### 7.1.1 配置中心
- 作用
  - 配置集中化
  - 配置动态化
- 数据结构
  - yaml格式
  - config/authentication
  - config/props
  - config/schema/schemeName/datasource
  - config/schema/sharding_db/rule
- 动态生效
### 7.1.2 注册中心
- 作用
- 数据结构
  - state/instances
  - state/datasources
- 熔断
- 禁用从库

### 7.1.3 元数据中心
- 元数据：数据源中的表、列、索引等。
- 数据结构
  - configuredSchemaMetaData
  - unconfiguredSchemaMetaDataMap
### 7.1.4 第三方组件依赖
- Zookeeper
- Etcd
- Apollo
- Nacos
## 7.2 可观察性
### 7.2.1 应用性能监控集成
- OpenTracing
- SkyWalking
### 7.2.2 度量指标监控
- Counter
- Gauge
- Histogram
- Summary
## 7.3 集群管理
### 7.3.1 心跳检测
### 7.3.2 集群状态拓扑

# 8. 弹性伸缩
## 8.1 概念
- 弹性伸缩作业
  - 指一次将旧分片规则伸缩至新分片规则的完整流程。
- 数据节点
  - 同数据分片中的数据节点
- 存量数据
  - 在弹性伸缩作业开始前，数据分片已有的数据。
- 增量数据
  - 在弹性伸缩作业过程中，业务系统所产生的数据
## 8.2 原理
- 冗余伸缩：建立新集群，伸缩完成后切换到新集群，删除旧集群
- 优点
  - 伸缩过程中，原始数据没有任何影响
  - 伸缩失败无风险
  - 不受原分片限制
- 缺点
  - 在一定时间内存在冗余服务器
  - 所有数据都需要移动
- 伸缩过程
  - 准备
  - 存量数据迁移
    - JDBC查询的方式，直接从数据点读取数据，并使用新规则写入到集群中。
  - 增量数据同步
    - mysql:订阅并解析binglog
    - postgreSQL:采用官方逻辑复制test_decoding
  - 规则切换
    - 存在一定时间的业务只读窗口期，短则数秒，长则数分钟
## 8.3 规范
- 支持项
  - 将外围数据迁移至 Apache ShardingSphere 所管理的数据库
  - 将 Apache ShardingSphere 的数据节点进行扩容或缩容
- 不支持项
  - 不支持无主键表的扩容和缩容

# 9. 数据加密
## 9.1 概念
- 待补充
## 9.2 原理
- TODO
- 内置加密算法
  - AES
  - MD5
## 9.3 规范
- 支持项
  - 后端数据库为 MySQL、Oracle、PostgreSQL、SQLServe
  - 用户需要对数据库表中某个或多个列进行加密（数据加密 & 解密）
  - 用户需要对数据库表中某个或多个列进行加密（数据加密 & 解密）
- 不支持项
  - 用户需要自行处理数据库中原始的存量数据、洗数
  - 使用加密功能+分库分表功能，部分特殊SQL不支持
  - 加密字段无法支持比较操作，如：大于小于、ORDER BY、BETWEEN、LIKE等
  - 加密字段无法支持计算操作，如：AVG、SUM以及计算表达式

# 10. 影子库压测
## 10.1 概念
- 影子字段：判断该条 SQL 是否需要路由到影子数据库，为逻辑字段，数据库中不存在
- 生产数据库：生产数据使用的数据库
- 影子数据库：进行压测数据隔离的影子数据库，与生产数据库应当使用相同的配置
## 10.2 原理
- 影子规则
  - 影子字段：逻辑字段，必填
  - 映射关系：一个生产数据库对应一个影子数据库，必填

# 测试引擎
## SQL测试用例
- 目标
- 流程
## 整合测试引擎
- 流程
## SQL解析测试引擎
## SQL改写测试引擎
## 性能测试
- 场景
  - 单路由
  - 主从
  - 主从+加密+分库分表
  - 全路由
  
