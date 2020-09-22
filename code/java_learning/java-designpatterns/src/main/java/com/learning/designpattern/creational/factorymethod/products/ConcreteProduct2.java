package com.learning.designpattern.creational.factorymethod.products;

import com.learning.designpattern.creational.factorymethod.IProduct;

/**
 *  具体的产品2
 * @author morning
 * @date 2020/9/21 21:14
 * @since 0.0.1
 */
public class ConcreteProduct2 implements IProduct {
    public void show() {
        System.out.println("concrete product 2");
    }
}
