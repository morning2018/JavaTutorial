package com.learning.multithrad.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：
 *  场景：当读多写少的情况下，使用读写锁可以提升性能
 *  特点：
 *    1. 写锁独享，读锁共享，读写互斥
 *    2. 读写分离
 *    3. 可重入
 *
 * @author morning
 * @date 2020/6/23 9:14
 * @version v0.0.1
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        Res res = new Res();
        // 一个线程写
        Thread w1 = new Thread(() -> {
            res.setRes("a",System.currentTimeMillis());
        });
        w1.start();
        Thread[] ths = new Thread[10];
        for (int i=0;i<ths.length;i++) {
            ths[i] = new Thread(() -> {
                System.out.println("读取到的数据：" + res.getRes("a"));
            });
        }
        for (int i=0;i<ths.length;i++) {
            ths[i].start();
        }
    }


    static class Res {
        /**读写锁*/
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        /**资源*/
        private Map<String, Object> res = new HashMap<>();

        /**获取资源**/
        public Object getRes(String key) {
            Object rtn = null;
            lock.readLock().lock();
            try {
                System.out.println("开始读取数据....");
                // 等待1秒钟，模拟处理业务
                TimeUnit.SECONDS.sleep(1);
                rtn = res.get(key);
                System.out.println("读取数据成功....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
            return rtn;
        }

        /**添加资源**/
        public void setRes(String key, Object obj) {
            lock.writeLock().lock();
            try {
                System.out.println("开始添加数据....");
                TimeUnit.SECONDS.sleep(1);
                res.put(key, obj);
                System.out.println("添加数据成功....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

}
