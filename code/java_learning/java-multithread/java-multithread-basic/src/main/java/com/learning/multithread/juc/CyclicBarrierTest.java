package com.learning.multithread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier说明：
 *  等待线程处于某种状态后，并发执行线程
 * @author morning
 * @date 2020/6/24 17:25
 * @version v0.0.1
 */
public class CyclicBarrierTest {

    private static final CyclicBarrier cb = new CyclicBarrier(5);


    public static void main(String[] args) {
        CyclicBarrierTest cbt = new CyclicBarrierTest();
        cbt.begin();
    }

    /**
     * 5个运动员比赛跑步
     */
    public void begin() {
        for(int i=0;i<5;i++){
            new Thread(new SportMan(i+1)).start();
        }
    }

    /**
     * 模拟运动员跑步
     */
    static final class SportMan implements Runnable{

        private  int i;
        public SportMan(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
                // 准备跑步
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运动员["+i+"]就绪，准备跑步....");
            try {
                // 等待发令枪
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("运动员["+i+"]开始跑步比赛....");
        }
    }
}
