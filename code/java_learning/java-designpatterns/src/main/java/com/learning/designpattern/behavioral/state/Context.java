package com.learning.designpattern.behavioral.state;

/**
 *  context role
 * @author morning
 * @date 2020/9/29 21:44
 * @since 0.0.1
 */
public class Context {
    private State state;
    public Context() {
        // init state
        this.state = new ConcreteStateA();
    }
    public void setState(State state) {
        this.state = state;
    }
    private State getState() {
        return this.state;
    }
    public void handle() {
        state.handle(this);
    }
}
