package com.learning.springboot.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = {"tx_queue"})
public class MyTxReceiver {

    /*@RabbitHandler
    public void receiver(String msg) {
        System.out.println("MyTxReceiver :" + msg);
    }*/
}
