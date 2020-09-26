package com.learning.designpattern.behavioral.template;

/**
 *  abstract class role
 * @author morning
 * @date 2020/9/26 20:32
 * @since 0.0.1
 */
public abstract  class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specificMethod() {
        System.out.println("specific method in abstract class is called.");
    }

    /**
     *  abstract method 1
     * @author morning
     * @date 2020/9/26 20:35
     * @since 0.0.1
     */
    public abstract void abstractMethod1();

    /**
     *  abstract method 2
     * @author morning
     * @date 2020/9/26 20:36
     * @since 0.0.1
     */
    public abstract void abstractMethod2();
}
