package com.learning.springboot.rabbitmq.config;

import com.learning.springboot.rabbitmq.constant.RabbitQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * descripiton: 设置队列
 *
 * @author: kinson(2219945910 @ qq.com)
 * @date: 2019/3/22
 * @time: 23:49
 * @modifier:
 * @since:
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue kinsonQueue() {
        return new Queue("kinson");
    }

    @Bean
    public Queue kinsonQueue2() {
        return new Queue("kinson2");
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(RabbitQueue.QUEUE_MAIL);
    }

    @Bean
    public Queue loginLogQueue() {
        return new Queue(RabbitQueue.QUEUE_LOGING_LOG);
    }
}
