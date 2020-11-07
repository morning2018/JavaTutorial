package com.learning.springboot;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * guava basic
 * @author weiyt
 * @date 2020/9/10 13:33
 * @since 0.0.1-SNAPSHOT
 */
public class GuavaListsTest {

    private static void testLists() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        list.add(6L);
        list.add(7L);
        list.add(8L);
        list.add(9L);
        list.add(10L);
        List<List<Long>> partList = Lists.partition(list, 5);
        System.out.println(JSON.toJSONString(partList));
    }

    public static void main(String[] args) {
        //testLists();
        //testNewArrayList();

        User user = new User();
        System.out.println(user.hashCode());
        user.setCode("111");
        System.out.println(user.hashCode());
        user.setUserId("111");
        System.out.println(user.hashCode());

    }

    @Data
    static class User {
        private String userId;
        private String name;
        private String code;
    }

    private static void testNewArrayList() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        Iterator<Long> iterator = list.iterator();
        Long first = iterator.next();
        System.out.println("first:" + first);
        List<Long> newList = Lists.newArrayList(iterator);
        System.out.println("new list:" + JSON.toJSONString(newList));
    }
}
