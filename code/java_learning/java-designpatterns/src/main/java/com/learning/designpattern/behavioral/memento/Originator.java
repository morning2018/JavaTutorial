package com.learning.designpattern.behavioral.memento;

/**
 *  originator role
 * @author morning
 * @date 2020/10/6 21:32
 * @since 0.0.1
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
