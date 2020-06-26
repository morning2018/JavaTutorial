package com.learning.thread;

public class DeadLockTest {
    private static final Object firstObejct = new Object();
    private static final Object secondObejct = new Object();

    public void firstToSecond() {
        String name = Thread.currentThread().getName();
        synchronized (firstObejct) {
            System.out.println(name + "get 1st");
            synchronized (secondObejct) {
                System.out.println(name + "get 2nd");
            }
        }
    }

    public void secondToFirst() {
        String name = Thread.currentThread().getName();
        synchronized (secondObejct) {
            System.out.println(name + "get 2nd");
            synchronized (firstObejct) {
                System.out.println(name + "get 1st");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        Thread
    }
}

