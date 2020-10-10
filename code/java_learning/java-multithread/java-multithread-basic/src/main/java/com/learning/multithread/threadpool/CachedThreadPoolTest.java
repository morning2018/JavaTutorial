package com.learning.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
public class CachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i=0; i<100; i++) {
            final int index = i;
            // 线程执行
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        //延迟i秒
                        Thread.sleep(1000 * index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务："+ index);
                    System.out.println("被线程" + Thread.currentThread().getName() + "执行");
                }
            });
        }

    }
}
