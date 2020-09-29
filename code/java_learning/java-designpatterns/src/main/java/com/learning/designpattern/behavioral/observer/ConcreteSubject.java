package com.learning.designpattern.behavioral.observer;

/**
 *  concrete subject
 * @author morning
 * @date 2020/9/29 22:11
 * @since 0.0.1
 */
public class ConcreteSubject extends AbstractSubject {
    
    /**
     * notify observer
     *
     * @author morning
     * @date 2020/9/29 22:10
     * @since 0.0.1
     */
    @Override
    public void notifyObserver() {
        System.out.println("concrete subject is changed...");
        System.out.println("------------------------------");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}
