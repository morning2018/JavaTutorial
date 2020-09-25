package com.learning.designpattern.structural.decorator;

/**
 *  concrete decorator role
 *
 * @author morning
 * @date 2020/9/24 21:35
 * @since 0.0.1
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }


    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("added function");
    }
}
