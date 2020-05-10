package com.learning.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        //表示延迟1秒后每3秒执行一次。
        pool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "执行");
            }
        }, 1,3, TimeUnit.SECONDS);

        //表示延迟2秒执行
        pool.schedule(new Runnable() {
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "执行");
            }
        }, 2, TimeUnit.SECONDS);

    }
}
