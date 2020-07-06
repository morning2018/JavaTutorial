# SpringCloud

## 概述
### SpringCloud是什么？


## Eureka注册中心
### Eureka是什么？
Eureka是Netflix公司开源的一款服务注册与发现的产品，基于restful实现，是springcloud体系中重要的组件之一。Eureka包括了EurekaServer和EurekaCLient两部分组成。目前Eureka提供了1.x的版本和2.x的版本，在2018年7月Netflix已经宣布停止维护2.x的版本。
### Eureka实现原理
```plantuml
agent EurekaServer
agent EurekaClient
agent EurekaClient2

EurekaServer --> EurekaClient
EurekaServer --> EurekaClient2
EurekaClient ..> EurekaClient2
```

### Eureka高可用

### Eureka VS Zookeeper

## Zuul网关

## OpenFeign

## Hystrix

## Ribbon

## Sleuth

>Reference:
>https://cloud.spring.io/spring-cloud-static/Hoxton.SR3/reference/html/spring-cloud-hoxton-configprops.html
>https://spring.io/projects/spring-cloud
>
