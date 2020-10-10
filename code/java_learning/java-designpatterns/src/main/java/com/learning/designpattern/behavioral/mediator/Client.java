package com.learning.designpattern.behavioral.mediator;

/**
 *  client
 * @author morning
 * @date 2020/10/6 20:13
 * @since 0.0.1
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague c1, c2, c3;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        c3 = new ConcreteColleague3();
        mediator.register(c1);
        mediator.register(c2);
        mediator.register(c3);
        c1.send();
        System.out.println("===============================");
        c2.send();
        System.out.println("===============================");
        c3.send();
    }
}
