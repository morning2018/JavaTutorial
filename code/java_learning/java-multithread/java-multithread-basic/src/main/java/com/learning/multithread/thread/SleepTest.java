package com.learning.multithread.thread;

/**
 *sleep函数：
 * public static native void sleep(long millis) throws InterruptedException;
 *  
 * @author morning
 * @date 2020/6/24 11:25
 * @version v0.0.1
 */
public class SleepTest {

    private class myThread extends  Thread {
        @Override
        public void run() {
            try {
                System.out.println("线程开始工作....");
                Thread.sleep(2000);
                System.out.println("线程结束工作....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("线程开始工作....");
            Thread.sleep(2000);
            System.out.println("线程结束工作....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
