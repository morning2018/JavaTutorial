package com.learning.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch：
 *  1.
 * @author morning
 * @date 2020/6/24 16:28
 * @version v0.0.1
 */
public class CountDownLatchTest {

    private static CountDownLatch cdl = new CountDownLatch(5);

    /**模拟前置工作*/
    static class PreWork extends Thread {
        @Override
        public void run() {
            try {
                // 执行1秒钟
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行preword");
            // 扣除1
            cdl.countDown();
        }
    }

    /**模拟业务工作*/
    static class BussWork extends Thread {
        private int i;
        public BussWork(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行业务[" + i+ "]");
        }
    }

    public static void main(String[] args) {

        Thread[] ts = new Thread[5];
        for (int i=0;i<ts.length;i++) {
            ts[i] = new Thread(new PreWork());
        }
        for (int i=0;i<ts.length;i++) {
            ts[i].start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 执行业务线程
        Thread[] ts2 = new Thread[10];
        for (int i=0;i<ts2.length;i++) {
            ts2[i] = new Thread(new BussWork(i));
        }
        for (int i=0;i<ts2.length;i++) {
            ts2[i].start();
        }

        System.out.println("main线程执行结束");
    }

}
