package com.learning.designpattern.structural.proxy;

/**
 *  代理的业务类
 * @author morning
 * @date 2020/9/20 19:24
 * @since 0.0.1
 */
public class Proxy implements ISubject{
    private RealSubject subject;

    /**
     *  代理的业务处理，可以进行业务增强
     * @author morning
     * @date 2020/9/20 19:25
     * @since 0.0.1
     */
    public void request() {
        if (subject == null) {
            subject = new RealSubject();
        }
        preRequest();
        subject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("pre do request");
    }

    private void postRequest() {
        System.out.println("post do request");
    }
}
