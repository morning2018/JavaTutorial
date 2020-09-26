package com.learning.designpattern.behavioral.command;

/**
 *  concrete command role
 * @author morning
 * @date 2020/9/26 20:57
 * @since 0.0.1
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;
    public  ConcreteCommand() {
        receiver = new Receiver();
    }

    public void execute() {
        receiver.action();
    }
}
