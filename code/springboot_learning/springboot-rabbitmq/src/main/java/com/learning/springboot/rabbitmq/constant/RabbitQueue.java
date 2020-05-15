package com.learning.springboot.rabbitmq.constant;

/**
 * 功能描述：
 *  Rabbit Queue 定义
 * @author morning
 * @date 2020/5/15 21:55
 * @version v0.0.1
 */
public final class RabbitQueue {

    /**
     * 发送邮件queue
     */
    public static final String QUEUE_MAIL= "queue.email";

    /**
     * 重置密码queue
     */
    public static final String QUEUE_RESET_PWD = "queue.reset.pwd";

    /**
     * 登录日志queue
     */
    public static final String QUEUE_LOGING_LOG = "queue.login.log";
}
