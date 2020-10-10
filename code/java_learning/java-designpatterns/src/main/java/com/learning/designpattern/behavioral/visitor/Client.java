package com.learning.designpattern.behavioral.visitor;

/**
 *  client
 * @author morning
 * @date 2020/10/6 21:20
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.add(new ConcreteElementA());
        structure.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        structure.accept(visitor);
        System.out.println("========================");
        visitor = new ConcreteVisitorB();
        structure.accept(visitor);
    }
}
