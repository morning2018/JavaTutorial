package com.learning.springboot.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.springboot.kafka.message.KafakaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
@Slf4j
public class KafakaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        KafakaMessage message = new KafakaMessage();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());

        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("kafaka-test-topic", gson.toJson(message));
    }
}
