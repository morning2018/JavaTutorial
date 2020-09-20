package com.learning.distributed.distributedlock.impl;

import com.learning.distributed.distributedlock.AbstractLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * 基于mysql实现分布式锁：
 *  
 * @author morning
 * @date 2020/7/7 10:24
 * @version v0.0.1
 */
public class MySqlLock extends AbstractLock {


    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void unLock() {

    }

    @Override
    public void waitLock() {

    }
}
