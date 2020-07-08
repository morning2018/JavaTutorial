# 概述
- 什么是shardingsphere?
- 为什么要用shardingsphere？
# 概念
## SQL相关概念
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
## 分片
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
## 配置
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
## 行表达式
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
## 分布式主键
- 内置UUID
  - UUID.randomUUID()
  - 无序
- 内置SNOWFLAKE
  - 2016年11月1日零点开始，可以使用到2086年
  - 时钟回拨问题需要设置时钟回拨秒数
- 思考：可以使用redis提供分布式主键
## 强制分片路由
- 实现动机
  - SQL携带分片条件，无侵入的自动解析
  - SQL不携带分片条件，基于Hint注入分片条件
- 实现机制
  - 基于ThreadLocal通过编程式向HintManager中添加分片条件，线程内生效
  - 计划基于SQL的hint方式注入分片条件
  - 指定了强制分片路由则会无视原有的分片逻辑
# 数据分片引擎
## 解析引擎
- 抽象语法树
  - 词法解析
  - 语法解析
  - 支持多种SQL方言
- SQL解析
  - 第一代：Druid实现，性能较好
  - 第二代:自研，采用"半理解"方式，不需要做全部的SQL解析，性能进一步提升
  - 第三代：ANTLR实现，还在替换进行中(202007)，增加SQL的兼容性，性能比第二代降低了3-10倍，建议采用PreparedStatement进行缓存加速。
## 路由引擎
- 分片路由（3种）
  - 直接路由
    - 路由条件苛刻：
  - 标准路由
  - 笛卡尔路由
- 广播路由
## 改写引擎
## 执行引擎
## 归并引擎
