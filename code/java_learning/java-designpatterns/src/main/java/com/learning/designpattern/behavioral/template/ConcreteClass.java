package com.learning.designpattern.behavioral.template;

/**
 *  concrete class role
 * @author morning
 * @date 2020/9/26 20:38
 * @since 0.0.1
 */
public class ConcreteClass  extends  AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("abstract method 1 is called.");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("abstract method 2 is called.");
    }
}
