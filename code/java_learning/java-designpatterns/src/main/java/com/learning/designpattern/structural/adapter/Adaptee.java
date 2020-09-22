package com.learning.designpattern.structural.adapter;

/**
 *  适配者
 * @author morning
 * @date 2020/9/22 22:02
 * @since 0.0.1
 */
public class Adaptee {
    public void specificRequest() {
        System.out.println("在适配者中的业务代码被调用。");
    }
}
