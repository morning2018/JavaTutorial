# docker快速安装mysql
## 环境信息
```sh
ip：192.168.44.128
os:centos7
虚拟机：4C/8G/60G
docker:Docker version 19.03.5, build 633a0ea
mysql：5.7
```

## 环境安装

docker启动mysql5.7命令：
- 启动3306端口
```shell
docker run --name mysql3306 -p 3306:3306 --privileged=true -ti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=smartpaas -e MYSQL_USER=user -e MYSQL_PASSWORD=pass -v /usr/docker/mysql5.7/3306/conf:/etc/mysql/conf.d -v /usr/docker/mysql5.7/3306/data/:/var/lib/mysql -v /usr/docker/mysql5.7/3306/logs/:/var/log/mysql -d mysql:5.7
```

进入docker修改mysql操作：
```shell
[root@promote local]# docker exec -it mysql3306 bash
root@6d135cc535e1:/# mysql -uroot -p123456
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.30 MySQL Community Server (GPL)

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use mysql;
```


- 启动3307端口mysql
```shell
docker run --name mysql3307 -p 3307:3306 --privileged=true -ti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=smartpaas -e MYSQL_USER=user -e MYSQL_PASSWORD=pass -v /usr/docker/mysql5.7/3307/conf:/etc/mysql/conf.d -v /usr/docker/mysql5.7/3307/data/:/var/lib/mysql -v /usr/docker/mysql5.7/3307/logs/:/var/log/mysql -d mysql:5.7
```
- 启动3308端口mysql
```shell
docker run --name mysql3308 -p 3308:3306 --privileged=true -ti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=smartpaas -e MYSQL_USER=user -e MYSQL_PASSWORD=pass -v /usr/docker/mysql5.7/3308/conf:/etc/mysql/conf.d -v /usr/docker/mysql5.7/3308/data/:/var/lib/mysql -v /usr/docker/mysql5.7/3308/logs/:/var/log/mysql -d mysql:5.7
```

## 优化参数

 ```shell
my.cnf
innodb_locks_unsafe_for_binlog  = off
innodb_flush_log_at_trx_commit  = 1
sync_binlog                     = 1
innodb_read_io_threads          = 8 
innodb_write_io_threads         = 32
innodb_thread_concurrency       = 32
thread_cache_size               = 100
innodb_buffer_pool_size         = 12884901888
 ```

