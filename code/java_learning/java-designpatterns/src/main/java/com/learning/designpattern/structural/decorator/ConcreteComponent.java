package com.learning.designpattern.structural.decorator;

/**
 *  concrete component role
 *  
 * @author morning
 * @date 2020/9/24 21:29
 * @since 0.0.1
 */
public class ConcreteComponent implements Component {
    /**
     *  ConcreteComponent  constructor
     *
     * @author morning
     * @date 2020/9/24 21:32
     * @since 0.0.1
     */
    public ConcreteComponent() {
        System.out.println("create concrete component");
    }

    /**
     *  concrete operation
     * @author morning
     * @date 2020/9/24 21:29
     * @since 0.0.1
     */
    public void operation() {
        System.out.println("Concrete Component operation is called.");
    }
}
