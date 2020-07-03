package com.learning.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisZSetService<V> {

    @Autowired
    private RedisTemplate<String, V> redisTemplate;

    public RedisTemplate template() {
        return redisTemplate;
    }
}
