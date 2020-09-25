package com.learning.designpattern.structural.bridge;

/**
 *  client
 * @author morning
 * @date 2020/9/24 21:22
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefineAbstraction(implementor);
        abstraction.operation();
    }
}
