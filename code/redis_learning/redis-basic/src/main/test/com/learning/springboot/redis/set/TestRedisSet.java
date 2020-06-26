package com.learning.springboot.redis.set;

import com.learning.springboot.Application;
import com.learning.springboot.redis.RedisSetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *  Redis Set相关操作
 * @author morning
 * @date 2020/5/12 11:25
 * @version v0.0.1
 */
@SpringBootTest(classes = Application.class)
public class TestRedisSet {

    @Autowired
    private RedisSetService<Object> redisSetService;

    @Test
    public void testSet() {
        // 添加Set元素
        redisSetService.add("blogSet", "blog1");
        redisSetService.add("blogSet", "blog2");

        // 设置超期时间
        redisSetService.template().expire("blogSet",1800, TimeUnit.SECONDS);
    }
}
