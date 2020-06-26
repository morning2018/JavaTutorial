package com.learning.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发容器：
 *  
 * @author morning
 * @date 2020/6/23 9:40
 * @version v0.0.1
 */
public class ConcurrentHashMapTest {

    private ConcurrentHashMap<Long, Long> userCount = new ConcurrentHashMap(16);

    public static void main(String[] args) {

    }
}
