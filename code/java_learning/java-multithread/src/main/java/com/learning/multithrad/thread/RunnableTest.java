package com.learning.multithrad.thread;

/**
 * 功能描述：
 *  Runnable实现多线程
 * @author morning
 * @date 2020/4/15 14:37
 * @version v0.0.1
 */
public class RunnableTest implements Runnable {
    /**
     * 票数
     */
    private static int ticket = 30;

    /**
     * 启动线程
     */
    public void run() {
        while (ticket > 0){
            //synchronized (this){
            synchronized (RunnableTest.class){
                System.out.println("售票员"+Thread.currentThread().getName()+"出票："+ticket);
                --ticket;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        RunnableTest rt = new RunnableTest();
        Thread t1 = new Thread(rt,"t1");
        Thread t2 = new Thread(rt,"t2");
        t1.start();
        t2.start();
    }
}
