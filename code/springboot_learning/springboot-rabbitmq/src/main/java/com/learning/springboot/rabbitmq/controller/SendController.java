package com.learning.springboot.rabbitmq.controller;


import com.learning.springboot.rabbitmq.constant.RabbitQueue;
import com.learning.springboot.rabbitmq.service.AckSenderService;
import com.learning.springboot.rabbitmq.service.ConfirmService;
import com.learning.springboot.rabbitmq.service.TransactionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * descripiton:
 *
 * @author: kinson(2219945910 @ qq.com)
 * @date: 2019/3/22
 * @time: 23:51
 * @modifier:
 * @since:
 */
@RestController
public class SendController {
    /**
     * 默认按类型
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AckSenderService senderService;

    @Autowired
    private TransactionService txService;

    @Autowired
    private ConfirmService confirmService;

    /**
     * 发送一条消息到一个队列
     * 采用默认Exchange(direct)
     * 如果有多个消费者，只能被消费一次
     * @return
     */
    @GetMapping(value = "sendEmail")
    public String sendEmail() {
        String content = "发送信息给www@126.com,时间：" + System.currentTimeMillis();
        //发送默认交换机(direct)对应的队列RabbitQueue.QUEUE_MAIL
        rabbitTemplate.convertAndSend(RabbitQueue.QUEUE_MAIL, content);
        return content;
    }

    /**
     * 单条消息发送
     *
     * @return
     */
    @GetMapping(value = "send")
    public String send() {
        String content = "Date:" + System.currentTimeMillis();
        //发送默认交换机对应的的队列kinson
        rabbitTemplate.convertAndSend("kinson", content);
        return content;
    }

    /**
     * 发送多条消息到一个队列RabbitQueue.QUEUE_MAIL，该队列有多个消费者
     * 采用默认Exchange(direct)
     * 每条消息只会被消费一次
     * @return
     */
    @GetMapping(value = "sendMore")
    public String sendMore() {
        List<String> result = new ArrayList<String>();
        //发送10条数据
        for (int i = 0; i < 100; i++) {
            String content = "第" + (i + 1) + "次发送 Date:" + System.currentTimeMillis();
            //发送默认交换机对应的的队列kinson,此时有两个消费者MyReceiver1和MyReceiver2,每条消息只会被消费一次
            rabbitTemplate.convertAndSend(RabbitQueue.QUEUE_MAIL, content);
            result.add(content);
        }
        return String.join("<br/>", result);
    }

    /**
     * 发送多条消息到多个队列
     *
     * @return
     */
    @GetMapping(value = "sendMoreQueue")
    public String sendMoreQueue() {
        List<String> result = new ArrayList<String>();
        //发送10条数据
        for (int i = 0; i < 10; i++) {
            String content = "第" + (i + 1) + "次发送 Date:" + System.currentTimeMillis();
            //发送默认交换机对应的的队列QUEUE_MAIL
            rabbitTemplate.convertAndSend(RabbitQueue.QUEUE_MAIL, content);
            //发送默认交换机对应的的队列QUEUE_LOGING_LOG
            rabbitTemplate.convertAndSend(RabbitQueue.QUEUE_LOGING_LOG, content);
            result.add(content);
        }
        return String.join("<br/>", result);
    }

    /**
     * Topic模式的exchange消息发送，此时topic.msg符合队列topic.msg和topic.msgs绑定的routingKey，
     * 故发送的消息会传送到队列topic.msg和topic.msgs
     *
     * @return
     */
    @GetMapping(value = "topicSend")
    public String topicSend() {
        String content = "topicSend :" + System.currentTimeMillis();
        //发送topicExchange交换机对应的的队列topic.msg
        rabbitTemplate.convertAndSend("topicExchange", "topic.msg", content);
        return content;
    }

    /**
     * Topic模式的exchange消息发送，此时topic.msgs符合只符合topic.msgs绑定的routingKey，
     * 故发送的消息只传送到队列topic.msgs
     *
     * @return
     */
    @GetMapping(value = "topicSend2")
    public String topicSend2() {
        String content = "topicSend2 :" + System.currentTimeMillis();
        //发送topicExchange交换机对应的的队列topic.msgs
        rabbitTemplate.convertAndSend("topicExchange", "topic.msgs", content);
        return content;
    }

    /**
     * @return
     */
    @GetMapping(value = "ackSend")
    public String ackSend() {
        senderService.send();

        return "ok";
    }

    /**
     * @return
     */
    @GetMapping(value = "sendObj")
    public String sendObj() {
        senderService.sendObj();

        return "ok";
    }

    /**
     * @return
     */
    @GetMapping(value = "txSend")
    public String txSend() throws URISyntaxException, IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        txService.publish();
        return "txSend";
    }

    /**
     * @return
     */
    @GetMapping(value = "txRec")
    public String txRec() throws InterruptedException, TimeoutException, IOException {
        txService.consume();
        return "txRec";
    }

    /**
     * @return
     */
    @GetMapping(value = "confirmSend")
    public String confirmSend() throws InterruptedException, TimeoutException, IOException {
        confirmService.publish();
        return "confirmSend";
    }

    /**
     * @return
     */
    @GetMapping(value = "confirmConsume")
    public String confirmConsume() throws InterruptedException, TimeoutException, IOException {
        confirmService.consume();
        return "confirmConsume";
    }

}
