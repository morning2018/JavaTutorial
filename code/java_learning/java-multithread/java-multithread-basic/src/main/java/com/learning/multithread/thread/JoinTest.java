package com.learning.multithread.thread;

public class JoinTest implements Runnable {

    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        JoinTest jt = new JoinTest();
        Thread t1 = new Thread(jt,"T1");
        Thread t2 = new Thread(jt,"T2");
        Thread t3 = new Thread(jt,"T3");

        // 启动T1线程
        t1.start();
        try {
            // main等待T1执行结束
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 启动T3线程
        t3.start();
        try {
            // main等待T3执行结束
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 启动T2线程
        t2.start();
        try {
            // main等待T2执行结束
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main执行结束");
    }
}
