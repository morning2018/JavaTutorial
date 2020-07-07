# 1.Zookeeper
## 1.1 概述
### 1.1.1 什么是Zookeeper？
### 1.1.2 发展历程
## 1.2 Zookeeper实现原理
### Zookeeper中的角色
- **Leader**:负责投票的发起和决议，更新系统状态。
- **Follower**:接收客户端请求，并向客户端返回结果，参与投票。
- **Observer**:接收客户端连接，将写请求转发给Leader,不参与投票，只同步Leader状态,可扩充系统，提高读并发。
- **客户端**：请求发起发

### 原子广播机制
### ZAB协议
- 恢复模式（选主）
- 广播模式（同步）





>Reference
>http://zookeeper.apache.org
