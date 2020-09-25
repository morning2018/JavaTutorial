package com.learning.designpattern.structural.flyweight;
/**
 *  abstract flyweight
 * @author morning
 * @date 2020/9/25 20:56
 * @since 0.0.1
 */
public interface Flyweight {
    /**
     *  operation
     * @author morning
     * @date 2020/9/25 20:58
     * @since 0.0.1
     * @param state
     */
    public void operation(UnsharedConcreteFlyweight state);
}
