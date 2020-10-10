package com.learning.designpattern.behavioral.memento;

/**
 *  client
 * @author morning
 * @date 2020/10/6 21:35
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("S0");
        System.out.println("init state:" + originator.getState());
        careTaker.setMemento(originator.createMemento());
        originator.setState("S1");
        careTaker.setMemento(originator.createMemento());
        originator.setState("S2");
        System.out.println("new state:" + originator.getState());
        originator.restoreMemento(careTaker.getMemento());
        System.out.println("restore state:" + originator.getState());
    }
}
