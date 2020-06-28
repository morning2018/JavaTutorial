package com.learning.thread;
/**
 * 死锁：
 *  针对多个资源，多个线程进行争抢，当顺序不正当时可能会产生死锁
 * 解锁：
 *  将两个线程的锁定顺序改成一样即可
 * @author morning
 * @date 2020/6/28 9:07
 * @version v0.0.1
 */
public class DeadLockTest {
    private final static  String firstObject = "1stLock";
    private final static  String secondObject = "2ndLock";

    public static void main(String[] args) {
        Thread lock1 = new Thread(new Lock1());
        Thread lock2 = new Thread(new Lock2());
        lock1.start();
        lock2.start();
    }

    /** 先锁定对象1，再锁定对象2*/
    static class Lock1 extends Thread {
        @Override
        public void run() {
            firstToSecond();
        }
        public void firstToSecond() {
            String name = Thread.currentThread().getName();
            synchronized (firstObject) {
                System.out.println(name + "get 1st lock");
                synchronized (secondObject) {
                    System.out.println(name + "get 2nd lock");
                }
            }
        }
    }

    /**先锁定对象1,在锁定对象2**/
    static class Lock2 extends Thread {
        @Override
        public void run() {
            secondToFirst();
        }

        public void secondToFirst() {
            String name = Thread.currentThread().getName();
            synchronized (secondObject) {
            //synchronized (firstObject) {// 将锁的顺序改成和Lock1一样，可解锁
                System.out.println(name + "get 2nd lock");
                synchronized (firstObject) {
                //synchronized (secondObject) {// 将锁的顺序改成和Lock1一样，可解锁
                        System.out.println(name + "get 1st lock");
                    }
                }
        }
    }
}

