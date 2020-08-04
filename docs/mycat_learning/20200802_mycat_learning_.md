# mycat学习

```plantuml
agent app
agent 订单
agent 购物车
agent 支付

database db
订单 --> db
购物车 -->db
支付 --> db
app --> 订单
app --> 购物车
app --> 支付
```
## 概念
 数据库拆分方式？
 - 垂直拆分
   ```plantuml
   agent app
   agent 订单
   agent 购物车
   agent 支付


   database 订单库
   database 购物车库
   database 支付库
   订单 --> 订单库
   购物车 -->购物车库
   支付 --> 支付库
   app --> 订单
   app --> 购物车
   app --> 支付
   ```
   - 缺点
     - 需要处理跨库join
       ```
       t_order join t_cart
       ```
     - 代码需要重构，需要处理分布式事务
       ```java
        @Transtational
        public void insert() {
          ......
          orderservice.insert();
          cartservice.insert();
          ......
        }
       ```
      - 跨库分页问题（跨库join与数据排序？）

 - 水平拆分
  对数据进行横向的扩展。
  当一个单表t_order有上亿数据会有哪些问题？
    ~~~
    1. 数据库节点的磁盘不够存储
    2. 数据查询慢（单表和关联查询）
    ~~~
  ```plantuml
  agent app
  agent 订单
  agent 购物车
  agent 支付

  database 订单库{
    agent t_order0
    agent t_order1
    agent t_order2
    agent t_order...
  }
  database 购物车库
  database 支付库
  订单 --> 订单库
  购物车 -->购物车库
  支付 --> 支付库
  app --> 订单
  app --> 购物车
  app --> 支付
  ```

  ```plantuml
  agent app
  agent 订单
  agent 购物车
  agent 支付

  database 订单库0
  database 订单库1
  database 订单库2
  database 订单库...

  database 购物车库
  database 支付库
  订单 --> 订单库0
  订单 --> 订单库1
  订单 --> 订单库2
  订单 --> 订单库...

  购物车 -->购物车库
  支付 --> 支付库
  app --> 订单
  app --> 购物车
  app --> 支付

  ```
## mycat架构
3个核心问题：
1. 扩库join问题
2. 分布式事务问题
3. 分页排序查询问题

数据切分经验：
一：能不切分尽量不要切分
二：如果要切分，选择合适的切分规则，提前规划
三：尽量通过冗余表或分组表降低跨库join的可能
四：业务读取尽量较少多表join

不生产数据，数据的搬运工
```plantuml
agent app
agent mycat
database db1
database db2
database db3
database db...

app --> mycat
mycat --> db1
mycat --> db2
mycat --> db3
mycat --> db...
```
### 核心功能
- 是一个数据库代理
- mysql、sql server、oracle、db2、postgresql，也支持对mongodb的存储
- mycat不做存储，只要数据路由
### 核心概念
- 重要的配置文件
  - server.xml
  - schema.xml
  - rule.xml
- 逻辑库
- 逻辑表
- 分片表
- 非分片表
- ER表
- 全局表

## 分片规则
- 取余
  - 缺点1：散列不均匀
  - 缺点2：扩容需要数据迁移
- hash枚举
- 时间分片
  - 按年分库按月分表
- 一致性hash算法

### 场景
- 非分片表
- 单片表（库内分片）
- 分片表(分库表)
- 分片表(分库分表)
- 主键取模
- 按年分库按月分表
- 单表查询
- 跨库join
- 分页排序
- 绑定表
- 笛卡尔积
- 分布式主键
