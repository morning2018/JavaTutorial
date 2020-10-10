package com.learning.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolTest {

    /**
     * 多线程下载文件
     */
    private static  class DownloadFile extends Thread {
        @Override
        public void run() {
            download();
        }

        private void download() {
            System.out.println("线程："+ Thread.currentThread().getName() + "开始下载文件....");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程："+ Thread.currentThread().getName() + "完成文件下载....");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        // 多任务下载
        for (int i = 0; i < 100; i++) {
            executorService.execute(new DownloadFile());
        }

        try {
            // work steal是守护线程，为了演示效果，等待线程执行完成
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
