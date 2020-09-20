package com.learning.multithrad.practice;

/**
 * 功能描述：
 *  多线程售票系统
 * @author morning
 * @date 2020/4/15 14:34
 * @version v0.0.1
 */
public class TicketingSystem extends Thread {
    /**
     * 票数
     */
    private static int ticket = 30;

    /**
     * synchronized锁定
     */
    private synchronized void sale() {
        if (ticket > 0) {
            System.out.println("售票员"+Thread.currentThread().getName()+"出票："+ticket);
            --ticket;
        }
    }
    @Override
    public void run() {
        try {
            while (ticket > 0) {
                sale();
                Thread.sleep(500);
            }
            System.out.println("票被售空了");
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }

    }


    public static void main (String[] args) {
        TicketingSystem ts = new TicketingSystem();
        Thread t1 = new Thread(ts,"t1");
        Thread t2 = new Thread(ts,"t2");
        Thread t3 = new Thread(ts,"t3");
        t2.start();
        t1.start();
        t3.start();
    }

}
