package com.learning.designpattern.structural.bridge;

/**
 *  abstraction role
 *
 * @author morning
 * @date 2020/9/24 21:17
 * @since 0.0.1
 */
public abstract class Abstraction {
    protected Implementor implementor;
    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     *  abstract operation define
     * @author morning
     * @date 2020/9/24 21:18
     * @since 0.0.1
     */
    public abstract void operation();
}
