package com.learning.springboot.kafka.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConfigurationConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationConsumer.class);
    private static final Gson GSON = new Gson();

    @KafkaListener(topics = {"software-discovery"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("software-discovery:" + record);

        System.out.printf("topic = %s, offset = %d, value = %s, key = %s%n", record.topic(), record.offset(), record.value(), record.key());
    }


}
