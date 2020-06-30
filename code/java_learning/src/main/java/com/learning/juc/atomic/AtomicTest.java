package com.learning.juc.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic测试：
 *  
 * @author morning
 * @date 2020/6/29 14:49
 * @version v0.0.1
 */
public class AtomicTest {
    
    private static AtomicInteger a  = new AtomicInteger();
    private static AtomicLong longAtom = new AtomicLong(10);
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    public static void main(String[] args) {
        System.out.println(a.incrementAndGet());
        System.out.println(longAtom.incrementAndGet());
        System.out.println(atomicBoolean.get());

    }
}
