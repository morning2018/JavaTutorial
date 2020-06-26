package com.learning.thread;

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
        // 读写锁
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock();
        lock.writeLock();

    }
}
