package com.learning.springboot.rabbitmq.consumer;

import com.learning.springboot.rabbitmq.constant.RabbitQueue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 * 监听RabbitQueue.QUEUE_LOGING_LOG队列
 * @author morning
 * @date 2020/5/19 14:41
 * @version v0.0.1
 */
@Component
@RabbitListener(queues = {RabbitQueue.QUEUE_LOGING_LOG})
public class LoginLogReceiver {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("LoginLogReceiver消费：" + msg);
    }
}
