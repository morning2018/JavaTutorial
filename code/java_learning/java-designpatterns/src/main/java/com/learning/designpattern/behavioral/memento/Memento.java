package com.learning.designpattern.behavioral.memento;

/**
 *  memento role
 * @author morning
 * @date 2020/10/6 21:31
 * @since 0.0.1
 */
public class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
