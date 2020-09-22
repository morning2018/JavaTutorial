package com.learning.designpattern.creational.builder;

/**
 *  client
 * @author morning
 * @date 2020/9/22 21:53
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new HuaWeiComputerBuilder();
        ComputerBuilderDirector computerBuilderDirector = new ComputerBuilderDirector(computerBuilder);
        Computer computer = computerBuilderDirector.construct();
        computer.show();
    }
}
