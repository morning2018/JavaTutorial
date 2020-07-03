# redis 性能优化
## 慢查询
 - 默认redis的慢查询为10毫秒，可以通过两种方式进行设置
   - 命令：config set slowlog-log-slower
   - 配置redis.conf
 - 慢查询存放在List，最大长度可以设置（slow-max-len）
   list生成设置为3000-5000，基于业务进行设置
 - slowlog-get
 
## 优化
 - bgsave
  一天执行1-2次，不会执行太多
## reds服务器压测

官网指标：QPS:10w+/s

上线之前，做好性能压测，形成各种报告


redis性能实战：

1.100个并发，10000个请求
```shell

redis-benchmark -h 192.168.44.128 -p 6377 -c 100 -n 10000

2c/4g 虚拟机 平均30000次/s
``` 



2. 测试存取大小为100个字节的数据包进行存取
```shell
redis-benchmark -h 192.168.44.128 -p 6377 -q -d 100
2c/4g 虚拟机 平均30000次/s
```
3. 只测试set,get的操作性能
```shell
redis-benchmark -h 192.168.44.128 -p 6377 -t set,get -n 100000 -q
2c/4g 虚拟机 平均25000次/s
```
4. 只测试某些数值存取的性能

```shell
redis-benchmark -h 192.168.44.128 -p 6377  -n 100000 -q script load "redis.call('set','foo','bar')"
2c/4g 虚拟机 平均25000次/s
```

## redis的运行原理
客户端 -> 发送请求命令