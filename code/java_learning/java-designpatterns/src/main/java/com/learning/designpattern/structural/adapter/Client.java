package com.learning.designpattern.structural.adapter;

/**
 *  client
 * @author morning
 * @date 2020/9/22 22:03
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
