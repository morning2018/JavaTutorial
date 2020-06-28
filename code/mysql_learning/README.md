- 事务并发问题
  - 脏读
    - 线程A读取了事务B更新的数据，然后事务B回滚了，导致事务A读的数据是脏数据。
  - 不可重复读
    - 事务A多次读取同一个数据，过程中该数据被事务B更改并提交，导致事务A多次读的数据不一致。
  - 幻读
    - 事务A更新了所有的满足条件的数据的值，在返回数据之前，事务B又新增了一条满足条件的数据，然后事务A在获取到返回列表时，发现还有一条没有更新，就好像发生幻觉一样。
- mysql事务的隔离级别
   
  |事务隔离级别 | 脏读 | 不可重复读 | 幻读
  | :----| :----: | :----: | :----: |
  |read-uncommitted | 是 | 是 | 是
  |read-committed   | 否 | 是 | 是
  |repeatable-read  | 是 | 否 |否
  |serializable     |否  |否  |否
 
- 验证
  - 查询mysql默认的隔离级别
  ```
    mysql> select @@tx_isolation;
    +-----------------+
    | @@tx_isolation  |
    +-----------------+
    | REPEATABLE-READ |
    +-----------------+
    1 row in set
  ```
  - 设置mysql隔离级别
  ```
    mysql> set session transaction isolation level read uncommitted;
    Query OK, 0 rows affected
    
    mysql> select @@tx_isolation;
    +------------------+
    | @@tx_isolation   |
    +------------------+
    | READ-UNCOMMITTED |
    +------------------+
    1 row in set
  ```
 - 读未提交（出现脏读）
   - 事务A查询余额
   ```
    mysql> set session transaction isolation level read uncommitted;
    Query OK, 0 rows affected
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1000 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
   ```
   - 事务B更新余额
   ```
    mysql> set session transaction isolation level read uncommitted;
    Query OK, 0 rows affected
    
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> update account set balance = 1200 where id = 1;
    Query OK, 1 row affected
    Rows matched: 1  Changed: 1  Warnings: 0
   ```
   - 事务A再次查询余额，已经变更
   ```
    mysql> select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1200 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
   ```
   - 事务B回滚更改,此时事务A查询的数据是一个脏数据
   ```
    mysql> rollback;
    Query OK, 0 rows affected
   ```
- 读提交(会出现不可重复读)
  - 事务A两次查询余额，两次查询的数据不一样
  ```
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql>  select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1200 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
    
    mysql>  select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1400 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
    
    mysql> commit;
    Query OK, 0 rows affected
  ```
  - 事务B在事务A第一次查询后，修改余额并提交,导致事务A出现不可重复读
  ```
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> update account set balance = 1200 where id = 1;
    Query OK, 1 row affected
    Rows matched: 1  Changed: 1  Warnings: 0
    
    mysql> commit;
    Query OK, 0 rows affected
    
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> update account set balance = 1400 where id = 1;
    Query OK, 1 row affected
    Rows matched: 1  Changed: 1  Warnings: 0
    
    mysql> commit;
    Query OK, 0 rows affected
  ```
- 可重复读(会出现幻读)
  - 事务A两次查询全量余额,再此期间又事务B，新增了一条记录（但是没有出现幻读）
  ```
    mysql> set session transaction isolation level repeatable read;
    Query OK, 0 rows affected
    
    mysql> select @@tx_isolation;
    +-----------------+
    | @@tx_isolation  |
    +-----------------+
    | REPEATABLE-READ |
    +-----------------+
    1 row in set
    
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1800 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
    
    mysql> select * from account;
    +----+----------+---------+
    | id | username | balance |
    +----+----------+---------+
    |  1 | zhangsan |    1800 |
    |  2 | lisi     |    2000 |
    +----+----------+---------+
    2 rows in set
    
    mysql> commit;
  ```
  - 事务B在事务A执行了第一次查询后，新增一条余额，并提交
  ```
    mysql> set session transaction isolation level repeatable read;
    Query OK, 0 rows affected
    
    mysql> select @@tx_isolation;
    +-----------------+
    | @@tx_isolation  |
    +-----------------+
    | REPEATABLE-READ |
    +-----------------+
    1 row in set
    
    mysql> start transaction;
    Query OK, 0 rows affected
    
    mysql> insert into account values(3,'wangwu',2000);
    Query OK, 1 row affected
    
    mysql> commint;
    1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'commint' at line 1
    mysql> commint;
    1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'commint' at line 1
    mysql> commit;
    Query OK, 0 rows affected
  ```
  - mysql采用了MVVC模式，在只是进行查询的时候不会出现幻读
  