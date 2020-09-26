package com.learning.designpattern.behavioral.strategy;

/**
 *  context class role
 * @author morning
 * @date 2020/9/26 20:45
 * @since 0.0.1
 */
public class Context {
    private Strategy strategy;
    public Strategy getStrategy() {
        return strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
