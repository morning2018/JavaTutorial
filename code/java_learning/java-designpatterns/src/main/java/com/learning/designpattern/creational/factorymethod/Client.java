package com.learning.designpattern.creational.factorymethod;

import com.learning.designpattern.creational.factorymethod.factorys.ConcreteFactory1;
import com.learning.designpattern.creational.factorymethod.factorys.ConcreteFactory2;

/**
 *  client
 * @author morning
 * @date 2020/9/21 21:19
 * @since 0.0.1
 */
public class Client {

    public static void main(String[] args) {
        IProduct product;
        AbstractFactory factory = new ConcreteFactory1();
        product = factory.newProduct();
        product.show();

        factory = new ConcreteFactory2();
        product = factory.newProduct();
        product.show();

    }
}
