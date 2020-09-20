package com.learning.distributed.distributedlock;
/**
 * 锁接口定义：
 *  
 * @author morning
 * @date 2020/7/7 10:28
 * @version v0.0.1
 */
public interface Lock {

    boolean tryLock();

    void unLock();
}
