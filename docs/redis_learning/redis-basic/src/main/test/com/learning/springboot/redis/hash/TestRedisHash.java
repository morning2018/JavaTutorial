package com.learning.springboot.redis.hash;

import com.learning.springboot.Application;
import com.learning.springboot.redis.RedisHashService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *  Redis测试
 * @author morning
 * @date 2020/5/11 22:05
 * @version v0.0.1
 */
@SpringBootTest(classes = Application.class)
public class TestRedisHash {

    @Autowired
    private RedisHashService<Map<Object,Object>> servcie;

    @Test
    public void testcase1() {
        // 添加元素
        //servcie.put("userList","user#1","user1");
        //print(servcie.get("userList", "user#1"));

        // 批量添加元素
        /*Map<Object, Object> map = new HashMap<>();
        map.put("user#2","user2");
        map.put("user#3","user3");
        servcie.putAll("userList", map);*/

        // 获取Hash
        print(servcie.entries("userList"));

        // 获取Keys
        print(servcie.keys("userList"));

        // 获取values
        print(servcie.values("userList"));
    }


    private void print(Object obj) {
        System.out.println("=================");
        System.out.println("========" + obj + "=========");
        System.out.println("=================");
    }

}
