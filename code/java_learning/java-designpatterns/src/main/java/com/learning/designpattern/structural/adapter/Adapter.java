package com.learning.designpattern.structural.adapter;

/**
 *  适配器
 * @author morning
 * @date 2020/9/22 22:03
 * @since 0.0.1
 */
public class Adapter extends  Adaptee implements Target {
    /**
     *  适配接口
     * @author morning
     * @date 2020/9/22 22:05
     * @since 0.0.1
     */
    public void request() {
        specificRequest();
    }
}
