package com.learning.springboot.rabbitmq.consumer;

import com.learning.springboot.rabbitmq.constant.RabbitQueue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @author morning
 * @date 2020/5/19 14:41
 * @version v0.0.1
 */
@Component
@RabbitListener(queues = {RabbitQueue.QUEUE_MAIL})
public class EmailReceiver {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("EmailReceiver消费：" + msg);
    }
}
