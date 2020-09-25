package com.learning.designpattern.structural.decorator;

/**
 *  client
 * @author morning
 * @date 2020/9/24 21:38
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();

        Component component1 = new ConcreteDecorator(component);
        component1.operation();
    }
}
