package com.learning.springboot;

import com.learning.springboot.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class TestStringRedis {

    @Autowired
    private RedisUtils redisUtils;
    @Test
    public void setString() {
        redisUtils.set("hello","world");
    }




    @Test
    public void batchSetString() {
        String key ;
        for (int i = 0;i < 100; i++) {
            key = "key" + i;
            redisUtils.set(key, "world" + i);
        }
    }

    @Test
    public void setObj() {
        User user = new User("张三","12800998876");
        redisUtils.set("user",user.toString());
    }

    class User {
        public User(String userName, String phone){
            this.phone = phone;
            this.userName = userName;
        }
        private String userName;
        private String phone;
    }

}
