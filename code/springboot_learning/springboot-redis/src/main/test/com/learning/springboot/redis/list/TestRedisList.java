package com.learning.springboot.redis.list;

import com.learning.springboot.Application;
import com.learning.springboot.redis.RedisStringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能描述：
 *  测试验证Redis List场景
 * @author morning
 * @date 2020/5/10 17:20
 * @version v0.0.1
 */
@SpringBootTest(classes = Application.class)
public class TestRedisList {
    
    @Autowired
    private RedisStringService<String> redisStringService;

    @Test
    public void testcase1() {
        // 头部删除一个菜单
        //print(redisUtils.leftPop("menuList"));

        // 头部添加一个元素
        //print(redisUtils.leftPush("menuList","leftPush1"));

        // 尾部删除一个元素
        //print(redisUtils.rightPop("menuList"));

        // 尾部添加一个元素
        //print(redisUtils.rightPush("menuList","rightPush1"));

        // 尾部添加多个元素
        print(redisStringService.rightPushAll("menuList","list1","list2","list3"));

        // 头部添加多个元素
        //print(redisUtils.leftPushAll("menuList","left1","left2","left3"));

        // 使用List添加多个元素到头部
        //List<String> menus = Arrays.asList("list1","list2","list3");
        //print(redisUtils.leftPushAllByCollection("menuList",menus));

        // 使用List添加多个元素到尾部
        //List<String> menus2 = Arrays.asList("list4","list5","list6");
        //print(redisUtils.rightPushAll("menuList",menus2));

        // 删除从头数的第一个list2元素
        //print(redisUtils.remove("menuList",1,"list2"));

        // 删除从尾数的第一个list4元素
        //print(redisUtils.remove("menuList",-1,"list4"));

        // 删除所有的list1
        //print(redisUtils.remove("menuList",0,"list1"));

    }

    private void print(Object obj) {
        System.out.println("=================");
        System.out.println("========" + obj + "=========");
        System.out.println("=================");
    }
}
