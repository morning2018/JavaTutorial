package com.learning.designpattern.behavioral.mediator;

/**
 *  concrete colleague1
 * @author morning
 * @date 2020/10/6 20:10
 * @since 0.0.1
 */
public class ConcreteColleague1 extends Colleague {
    /**
     * concrete colleague1 receive
     *
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    @Override
    public void receive() {
        System.out.println("concrete colleague1 receive message.");
    }

    /**
     * concrete colleague1 send
     *
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    @Override
    public void send() {
        System.out.println("concrete colleague1 send message.");
        mediator.relay(this);
    }
}
