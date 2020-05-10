package com.learning.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述：
 *  创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 * @author yt.wei
 * @date 2020/5/6 16:12
 * @version v0.0.1
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            // 线程执行
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        //任务处理时间
                        Thread.sleep(1000 * index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务："+ index);
                    System.out.println("被线程" + Thread.currentThread().getName() + "执行");
                }
            });
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        //任务处理时间
                        Thread.sleep(500 * index);
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
