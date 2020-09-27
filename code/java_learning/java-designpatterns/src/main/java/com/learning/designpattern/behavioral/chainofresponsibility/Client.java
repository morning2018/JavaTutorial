package com.learning.designpattern.behavioral.chainofresponsibility;

/**
 *  client
 * @author morning
 * @date 2020/9/27 21:26
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNext(handler2);

        handler1.handlerRequest("two");
    }
}
