>Reference:
>https://spring.io/projects/spring-boot
>https://redis.io/topics/persistence
>https://redis.io/commands

### 概述
技术点：
- redis 5.0.5
- springboot 2.2.6

### springboot-redis搭建
### Redis String场景验证
#### 基本新增，修改，删除

### Redis List场景验证
#### leftpush/leftpop/rigthpush/rightpop

### Redis Hash场景验证
#### put/putall/delete/keys/entries/values

### Redis Set场景验证
### Redis ZSet场景验证

### Redis易用性
  - 支持多种数据格式
  - 支持多种客户端语言
  - 可以简单的实现各种场景
  - 数据支持自动化淘汰
### Redis高靠性
   - 支持持久化
     - aof
        - berewriteaof,重写进行
     - rdb
      - bgsave,定时进行数据持久化，手动进行持久化
     - 控制到秒级的数据丢失
   - 淘汰机制，防止内存撑爆
     - lru
     - ttl
   - 事务，防止出现垃圾数据
     - 弱事务
### Redis高可用验证
   - 支持主从
   - 支持哨兵
   - 支持集群结构
  
### Redis高性能验证
   - 10w+ QPS
   - 纯内存操作
   - 单线程，减少上下文切换
   - 多路复用机制
   - 支持pipeline操作
     - 批量操作减少网络交互
   - C语言编写
### Redis使用场景
 - 分布式锁
   - string 类型
   - 核心使用setnx
   - threadlocal
 - 分布式唯一订单号
   - string类型
   - incr和incrby
   - 核心思想是二级缓存
 - 分布式session管理
   - string类型 
   - 管理超时时间
   - 分布式会话
 - 排行榜（开发商排行榜）
   - zset类型
   - zrange/zrerange命令
 - 计数器
   - string
   - zset
   - hash
 - 队列
   - list
 - DDOS攻击
   - 手机号登录，记录手机号和登录时间，设置超期时间为30秒
 - 阻塞队列