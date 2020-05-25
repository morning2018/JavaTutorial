>Reference:
>https://spring.io/projects/spring-cloud-netflix#overview
>https://start.spring.io/
>https://segmentfault.com/a/1190000008378268

#### 概述
- 技术点：
  - springboot 2.2.6
  - springcloud Hoxton.SR3
  - eureka
- 目标
  - 快速搭建单节点注册中心
- 测试用例

  - 启动eureka服务，能正常访问http://localhost:18080/显示正常的界面
### Eureka服务注册中心搭建

#### maven引用
```
<!--提供eureka server-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```






