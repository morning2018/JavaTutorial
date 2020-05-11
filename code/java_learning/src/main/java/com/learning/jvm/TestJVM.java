package com.learning.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *  测试JVM相关参数
 * @author morning
 * @date 2020/4/15 21:40
 * @version v0.0.1
 */
public class TestJVM {
    static class User {
        private String userName;
        private String phone;
    }

    public static  void main(String[] args) {
        int a = 0;
        List<User> list = new ArrayList<User>();
        while (true) {
            User user = new User();
            user.userName = "zhang";
            list.add(user);
        }
    }
}
