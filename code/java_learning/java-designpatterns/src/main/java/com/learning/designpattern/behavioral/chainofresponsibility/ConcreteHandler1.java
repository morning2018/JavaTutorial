package com.learning.designpattern.behavioral.chainofresponsibility;

/**
 *  concrete handler 1
 * @author morning
 * @date 2020/9/27 21:21
 * @since 0.0.1
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void handlerRequest(String request) {
        if (request.equals("one")) {
            System.out.println("concrete handler 1 handle...");
        }
        else {
            if (getNext() != null) {
                getNext().handlerRequest(request);
            }
            else {
                System.out.println("no handler");
            }
        }
    }
}
