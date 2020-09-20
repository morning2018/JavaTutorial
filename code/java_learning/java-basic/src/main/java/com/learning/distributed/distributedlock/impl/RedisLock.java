package com.learning.distributed.distributedlock.impl;

import com.learning.distributed.distributedlock.AbstractLock;

/**
 * 基于Redis实现分布式锁：
 *  
 * @author morning
 * @date 2020/7/7 10:24
 * @version v0.0.1
 */
public class RedisLock extends AbstractLock {


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
