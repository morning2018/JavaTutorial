package com.learning.designpattern.behavioral.observer;

/**
 *  concrete observer role
 * @author morning
 * @date 2020/9/29 22:04
 * @since 0.0.1
 */
public class ConcreteObserver2 implements Observer {
    /**
     * response
     *
     * @author morning
     * @date 2020/9/29 22:02
     * @since 0.0.1
     */
    @Override
    public void response() {
        System.out.println("concrete observer 2 response");
    }
}
