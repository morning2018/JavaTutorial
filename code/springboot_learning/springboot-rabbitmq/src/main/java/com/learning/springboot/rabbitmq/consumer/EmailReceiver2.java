package com.learning.springboot.rabbitmq.consumer;

import com.learning.springboot.rabbitmq.constant.RabbitQueue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = {RabbitQueue.QUEUE_MAIL})
public class EmailReceiver2 {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("EmailReceiver2消费：" + msg);
    }
}
