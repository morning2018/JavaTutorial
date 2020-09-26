package com.learning.designpattern.behavioral.template;

/**
 *  client
 * @author morning
 * @date 2020/9/26 20:38
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass template = new ConcreteClass();
        template.templateMethod();
    }
}
