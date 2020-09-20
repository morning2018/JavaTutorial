package com.learning.multithrad.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 功能描述：
 *  因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
 *  定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache。
 * @author morning
 * @date 2020/5/6 16:00
 * @version v0.0.1
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
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
        }

    }
}
