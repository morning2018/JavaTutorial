package com.learning.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;;

public class ThreadPoolExecutor2Test {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(16,32, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(2000));
        for (int i=0;i<10000; i++) {
            executorService.execute(new WorkThread(i));
        }
    }

    private static class WorkThread implements Runnable {
        private int i;

        public WorkThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"开始执行任务" + i);
            if (i == 9999) {
                System.out.println("最后一个任务执行了。。。。。。");
            }
        }
    }
}
