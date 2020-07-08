package com.learning.distributed.distributedlock;

/**
 * 分布式锁：
 *  抽象模板锁，供client调用
* @author morning
 * @date 2020/7/7 10:17
 * @version v0.0.1
 */
public abstract class AbstractLock implements Lock {

    /**
      * 功能描述:
      *  
      * @author morning
      * @date 2020/7/7 10:21
      * @version v0.0.1
       * @param null   
       * @return  null
      */
    @Override
    public abstract  boolean tryLock();

    public void getLock(){

    }

    /**
      * 功能描述:
      *  
      * @author morning
      * @date 2020/7/7 10:22
      * @version v0.0.1
       * @param null   
       * @return  null
      */
    public abstract void waitLock();
}
