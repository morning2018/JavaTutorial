package com.learning.designpattern.structural.bridge;

/**
 *  concrete implementor A
 * @author morning
 * @date 2020/9/24 21:15
 * @since 0.0.1
 */
public class ConcreteImplementorA implements Implementor {

    /**
     *  operation impl
     * @author morning
     * @date 2020/9/24 21:15
     * @since 0.0.1
     */
    public void operationImpl() {
        System.out.println("conrete implementor a is called.");
    }
}
