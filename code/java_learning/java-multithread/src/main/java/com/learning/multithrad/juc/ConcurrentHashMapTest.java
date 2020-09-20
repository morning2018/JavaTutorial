package com.learning.multithrad.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发容器：
 *  
 * @author morning
 * @date 2020/6/23 9:40
 * @version v0.0.1
 */
public class ConcurrentHashMapTest {
    // 资源
    private static Map<String, Object> userCount = new ConcurrentHashMap(16);

    public static void main(String[] args) throws InterruptedException {
        // 10个线程写资源
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int j = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "准备设置数据....");
                    userCount.put(String.valueOf(j), "val"+j);
                    System.out.println(Thread.currentThread().getName() + "设置数据成功....");
                }
            });
            threads[i].start();

        }
        for (int i = 0; i < 10; i++) {
            // 先写完再进行读
            threads[i].join();
        }
        System.out.println("============================");
        for (Map.Entry entry : userCount.entrySet()) {
            System.out.println("["+entry.getKey()+"]:"+entry.getValue());
        }
        System.out.println("============================");
        // 等待线程执行完成
        Thread.sleep(1000);

        // 10个线程读资源
        for (int i = 0; i < 10; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("准备获取数据....");
                    System.out.println("获取数据：" + userCount.get(String.valueOf(k)));
                }
            }).start();
        }
    }
}
