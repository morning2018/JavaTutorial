>Reference:
>https://spring.io/projects/spring-cloud-netflix#overview
>https://start.spring.io/
>https://segmentfault.com/a/1190000008378268
>https://blog.csdn.net/qwe86314/article/details/94552801
### 概述
- 技术点：
  - springboot 2.2.6
  - springcloud Hoxton.SR3
  - eureka

### Eureka服务注册中心搭建

#### maven引用
```
<!--提供eureka server-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
### eureka高可用搭建

### eureka工作原理原理
- eureka server
  - 服务注册表
  - 心跳机制
- eureka client
- 服务注册

- 服务续约
- 服务下线
- 服务拉取
- 同步状态
- 远程调用
- 自我保护机制

### eureka高可用原理
- eureka region
- eureka zone
- 数据弱一致性(保证了AP)
  - 保证了高可用
  - 数据非一致性，业务应用通过重试、熔断等手段进行规避。
- P2P的数据同步机制
- Client端缓存机制


### 总结
eureka注重注册中心高可用，降低数据的一致性，在一定时间内可以允许不同服务器之间的数据是不一致的。





