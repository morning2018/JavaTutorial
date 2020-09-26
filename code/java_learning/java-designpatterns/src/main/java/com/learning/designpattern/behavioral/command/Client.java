package com.learning.designpattern.behavioral.command;

/**
 *  client
 * @author morning
 * @date 2020/9/26 21:00
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
