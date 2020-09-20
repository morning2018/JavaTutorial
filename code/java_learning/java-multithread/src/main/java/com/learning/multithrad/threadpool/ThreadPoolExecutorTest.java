package com.learning.multithrad.threadpool;

import java.util.concurrent.*;

/**
 * 线程池：
 *
 *
 * @author morning
 * @date 2020/6/22 13:09
 * @version v0.0.1
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8));


        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                   /* try {
                        // 执行业务3秒钟
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("当前线程："+ Thread.currentThread().getName() +"处理数据：");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("当前线程："+ Thread.currentThread().getName() + "释放。");
                    }
                }
            });
        }

        try {
            executorService.awaitTermination(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    
}
