package com.learning.designpattern.structural.proxy;

/**
 *  真实业务主题
 * @author morning
 * @date 2020/9/20 19:23
 * @since 0.0.1
 */
public class RealSubject implements ISubject{

    /**
     *  真实的业务处理
     * @author morning
     * @date 2020/9/20 19:23
     * @since 0.0.1
     */
    public void request() {
        System.out.println("真实的业务处理......");
    }
}
