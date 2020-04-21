package com.learning.thread;
/**
 * 功能描述：
 *  Volatile可见性验证
 * @author morning
 * @date 2020/4/21 10:54
 * @version v0.0.1
 */
public class VolatileTest extends Thread {
    /**
     * 循环标志，无限循环不一定停止
     */
    private static  boolean flay = false;
    /**
     * 循环标志，一定能让循环停止
     */
     //private static volatile boolean flay = false;

    /**
     * 线程启动方法
     */
    @Override
     public void run() {
        // 线程无限循环，直到外部打断
        while (!flay){
            System.out.println("线程持续运行");
        }
        System.out.println("线程停止运行了");
     }

    /**
     * main方法，测试线程
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread t = new Thread(new VolatileTest());
        //启动线程
        t.start();
        // 保证线程能进入循环
        Thread.sleep(1000);
        // 修改全局变量,停止线程运行
        flay = true;
    }
}
