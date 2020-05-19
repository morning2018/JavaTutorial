>Reference:
>https://start.spring.io/
>https://www.rabbitmq.com/
>https://www.rabbitmq.com/install-rpm.html
>https://www.rabbitmq.com/configure.html
>https://spring.io/guides/gs/messaging-rabbitmq/
>https://github.com/spring-guides?q=&type=&language=java
>https://github.com/fujiangwei/springboot-learn/tree/master/springboot-rabbitmq
>https://github.com/rabbitmq/rabbitmq-server/blob/master/docs/rabbitmq.conf.example
>https://www.cnblogs.com/vipstone/p/9350075.html
### springboot-rabbit搭建
 #### docker安装rabbitmq
 #### java实现
 - 配置
 - 生产者
 - 消费者
 - Exchange
 - Queue
 - rounting key
 - Binding
 #### 默认Exchange-Direct Exchange
   - 一条消息发送到一个Queue
     - 一个消费者
     - 多个消费者
   - 多条消息发送到一个Queue
     - 一个消费者
     - 多个消费者
   - 多条消息发送到多个Queue
     - 多个消费者
 #### Fanout Exchange
   - 确定消息发送成功
   - 消息发送失败
   - 发送对象消息
 #### Topic Exchange
   - 一条消息路由到多个Queue
   - 一条消息路由到单个Queue
 #### Header Exchange
 
 #### Channel事务机制
  确保消息被投递到Broker,但是性能低
   - 事务操作
     - channel.txSelect()
     - channel.txCommit()
     - channel.txRollback()
   - 单条消费事务
     - basicPublish
     - basicGet
   - 消息拒绝和确认
     - basicReject
     - basicAck
 #### Channel确认模式
 保证消息被投送到Broker
   - 确认操作
     - channel.confirmSelect()
     - channel.waitForConfirms()
     - channel.waitForConfirmsOrDie()
     - channel.addConfirmListener