package com.learning.designpattern.behavioral.observer;

/**
 *  client
 * @author morning
 * @date 2020/9/29 22:13
 * @since 0.0.1
 */
public class Client {

    public static void main(String[] args) {
        AbstractSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
    }
}
