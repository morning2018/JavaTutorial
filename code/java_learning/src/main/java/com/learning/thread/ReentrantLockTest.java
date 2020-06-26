package com.learning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *  ReentrantLock测试
 * @author morning
 * @date 2020/4/15 15:24
 * @version v0.0.1
 */
public class ReentrantLockTest implements Runnable {
    /**
     * 票数
     */
    private static int ticket = 30;
    private Lock lock = new ReentrantLock();
    public void run() {
        while (ticket > 0) {
            try {
                // 加锁
                lock.lock();
                System.out.println("售票员"+Thread.currentThread().getName()+"出票："+ticket);
                --ticket;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                // 解锁
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        RunnableTest rt = new RunnableTest();
        Thread t1 = new Thread(rt,"t1");
        Thread t2 = new Thread(rt,"t2");
        t1.start();
        t2.start();
    }
}
