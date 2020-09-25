package com.learning.designpattern.structural.flyweight;

/**
 *  client
 * @author morning
 * @date 2020/9/25 21:08
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("a");
        Flyweight flyweight2 = factory.getFlyweight("a");
        Flyweight flyweight3 = factory.getFlyweight("a");
        Flyweight flyweight4 = factory.getFlyweight("b");
        Flyweight flyweight5 = factory.getFlyweight("b");
        flyweight1.operation(new UnsharedConcreteFlyweight("first call a"));
        flyweight2.operation(new UnsharedConcreteFlyweight("second call a"));
        flyweight3.operation(new UnsharedConcreteFlyweight("third call a"));
        flyweight4.operation(new UnsharedConcreteFlyweight("first call b"));
        flyweight5.operation(new UnsharedConcreteFlyweight("second call b"));

    }
}
