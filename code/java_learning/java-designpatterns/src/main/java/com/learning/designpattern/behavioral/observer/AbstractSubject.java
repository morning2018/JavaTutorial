package com.learning.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *  abstract subject
 * @author morning
 * @date 2020/9/29 22:00
 * @since 0.0.1
 */
public abstract class AbstractSubject {
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     *  notify observer
     * @author morning
     * @date 2020/9/29 22:10
     * @since 0.0.1
     */
    public abstract void notifyObserver();

}
