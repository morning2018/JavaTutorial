package com.learning.designpattern.structural.decorator;

/**
 *  decorator role
 * @author morning
 * @date 2020/9/24 21:34
 * @since 0.0.1
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
