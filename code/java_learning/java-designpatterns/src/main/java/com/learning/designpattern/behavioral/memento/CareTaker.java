package com.learning.designpattern.behavioral.memento;

/**
 *  caretaker role
 * @author morning
 * @date 2020/10/6 21:35
 * @since 0.0.1
 */
public class CareTaker {
    private Memento memento;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}
