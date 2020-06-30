package com.learning.springboot.kafka.message;

import lombok.Data;

/**
 * 功能描述：
 *  消息体
 * @author morning
 * @date 2020/4/17 15:49
 * @version v0.0.1
 */
@Data
public class KafakaMessage {
    private Long id;
    private String msg;
}
