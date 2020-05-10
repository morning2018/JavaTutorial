package com.learning.springboot;

import com.learning.springboot.redis.RedisUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = Application.class)
public class TestGet {

    @Autowired
    private RedisUtils redisUtils;

    @BeforeEach
    public void initData() {
        redisUtils.set("user#1","123456");
        redisUtils.set("user#2","8080");
        System.out.println("set value");
    }

    @Test
    public void testcase1() {
        String value = (String)redisUtils.get("user#1");
        System.out.println(value);
        Assert.hasText(value,"123456");
    }

    @Test
    public void testcase2() {
        String value = (String)redisUtils.get("user#2");
        System.out.println(value);
        Assert.hasText(value,"8080");
    }
}
