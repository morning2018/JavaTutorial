package com.learning.designpattern.creational.prototype;

/**
 *  client
 * @author morning
 * @date 2020/9/20 21:27
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype realizetype2 = (Realizetype)realizetype.clone();
        System.out.println("realizetype==realizetype2 : " + (realizetype==realizetype2));
    }
}
