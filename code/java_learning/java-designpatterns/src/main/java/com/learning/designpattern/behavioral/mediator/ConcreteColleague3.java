package com.learning.designpattern.behavioral.mediator;

/**
 *  concrete colleague3
 * @author morning
 * @date 2020/10/6 20:10
 * @since 0.0.1
 */
public class ConcreteColleague3 extends Colleague {
    /**
     * concrete colleague2 receive
     *
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    @Override
    public void receive() {
        System.out.println("concrete colleague3 receive message.");
    }

    /**
     * concrete colleague3 send
     *
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    @Override
    public void send() {
        System.out.println("concrete colleague3 send message.");
        mediator.relay(this);
    }
}
