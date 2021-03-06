package com.learning.designpattern.behavioral.state;

/**
 *  concrete state role
 * @author morning
 * @date 2020/9/29 21:53
 * @since 0.0.1
 */
public class ConcreteStateB extends State {
    
    @Override
    public void handle(Context context) {
        System.out.println("current state is B");
        // change state to A
        context.setState(new ConcreteStateA());
    }
}
