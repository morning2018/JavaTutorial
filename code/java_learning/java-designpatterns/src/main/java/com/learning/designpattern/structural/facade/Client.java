package com.learning.designpattern.structural.facade;

/**
 *  client
 * @author morning
 * @date 2020/9/25 20:51
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
