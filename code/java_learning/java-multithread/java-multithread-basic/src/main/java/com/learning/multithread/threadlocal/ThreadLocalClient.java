package com.learning.multithread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  thread local client
 * @author morning
 * @date 2020/10/16 21:26
 * @since 0.0.1
 */
public class ThreadLocalClient {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0;i < 10; i++) {
            int a = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    StringThreadLocalTest.set(Thread.currentThread().getName() + a);
                    mockBusinessMap("A" + a);
                    mockBusinessMap("B" + a);
                    mockBusinessMap("C" + a);
                    mockPrint();
                    // 测试
                    mockBusiness();
                }
            });
        }
    }


    private static void mockBusinessMap(String key) {
        MapThreadLocalTest.set(key , Thread.currentThread().getName());
    }

    private static void mockPrint() {
        MapThreadLocalTest.print();
    }

    private static void mockBusiness() {
        System.out.println("线程数据：" + StringThreadLocalTest.get());
        MapThreadLocalTest.print();
        MapThreadLocalTest.remove();
        MapThreadLocalTest.print();
    }
}
