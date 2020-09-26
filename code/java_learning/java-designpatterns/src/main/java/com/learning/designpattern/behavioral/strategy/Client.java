package com.learning.designpattern.behavioral.strategy;
/**
 *  client
 * @author morning
 * @date 2020/9/26 20:47
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.strategyMethod();
        System.out.println("========================");
        strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        context.strategyMethod();
    }
}
