package com.learning.designpattern.creational.factorymethod.factorys;

import com.learning.designpattern.creational.factorymethod.AbstractFactory;
import com.learning.designpattern.creational.factorymethod.IProduct;
import com.learning.designpattern.creational.factorymethod.products.ConcreteProduct2;

/**
 *  产品2的工厂
 * @author morning
 * @date 2020/9/21 21:17
 * @since 0.0.1
 */
public class ConcreteFactory2 implements AbstractFactory {

    public IProduct newProduct() {
        return new ConcreteProduct2();
    }
}
