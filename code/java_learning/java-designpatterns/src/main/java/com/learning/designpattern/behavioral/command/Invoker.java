package com.learning.designpattern.behavioral.command;

/**
 *  invoker role
 * @author morning
 * @date 2020/9/26 20:53
 * @since 0.0.1
 */
public class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void setCommand() {
        this.command = command;
    }
    public void call() {
        System.out.println("invoker call command...");
        command.execute();
    }

}
