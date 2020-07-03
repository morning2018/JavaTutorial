package com.learning.springboot.redis.string;

import com.learning.springboot.redis.RedisStringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStringRedis {

    @Autowired
    private RedisStringService redisStringService;
    @Test
    public void setString() {
        redisStringService.set("hello","world");
    }

    @Test
    public void batchSetString() {
        String key ;
        for (int i = 0;i < 1000; i++) {
            key = "key" + i;
            redisStringService.set(key, "world" + i);
        }
    }

    @Test
    public void batchDelete() {
        String key ;
        for (int i = 0;i < 100; i++) {
            key = "key" + i;
            redisStringService.delete(key);
        }
    }

    @Test
    public void setObj() {
        User user = new User("张三","12800998876");
        redisStringService.set("user",user.toString());
    }

    @Test
    public void setJosn(){
        String json = "{}";
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
