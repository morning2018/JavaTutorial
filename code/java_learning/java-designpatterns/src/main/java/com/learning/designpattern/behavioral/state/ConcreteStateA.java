package com.learning.designpattern.behavioral.state;

/**
 *  concrete state role
 * @author morning
 * @date 2020/9/29 21:47
 * @since 0.0.1
 */
public class ConcreteStateA extends State {

    @Override
    public void handle(Context context) {
        System.out.println("current state is A");
        // change state to B
        context.setState(new ConcreteStateB());
    }
}
