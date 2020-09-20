package com.learning.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 同步Vmware资源：
 * 调用SDK同步资源：
 * 1.虚拟机
 * 2.宿主机
 * 3.网络
 * 4.IP地址
 * 5.镜像
 * 6.虚拟机存储
 * 7.资源池
 * 要求：
 * 1.200台机器量，在1分钟之内同步完成
 * 2.同步过程同时返回到界面进度
 */
public class VmwareSync {
    private static ExecutorService executorService = new ThreadPoolExecutor(0, 9,0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    private static  CountDownLatch countDownLatch = new CountDownLatch(3);
    // 模拟同步
    public static void main(String[] args) throws InterruptedException {
        VmwareSync vmwareSync = new VmwareSync();
        for (int i=0;i<10;i++) {
            vmwareSync.sync();
        }
    }

    public void sync() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 同步宿主机
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                List list = syncphyHost();
                countDownLatch.countDown();
                return list;
            }
        });
        // 同步虚拟机
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                List list = syncVirHost();
                countDownLatch.countDown();
                return list;
            }
        });
        // 同步网络
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                List list = syncNetwork();
                countDownLatch.countDown();
                return list;
            }
        });
        countDownLatch.await();
        System.out.println("vmware同步完成");
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+ (end-start));
    }


    public List syncVirHost() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"同步虚拟机....");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"同步虚拟机完成....");
        return new ArrayList();
    }

    public List syncphyHost() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"同步物理机....");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"同步物理机完成....");
        return new ArrayList();
    }

    public List syncNetwork() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"同步网络....");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"同步网络完成....");
        return new ArrayList();
    }
}
