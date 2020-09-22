package com.learning.designpattern.creational.factorymethod;

/**
 *  抽象的工厂
 * @author morning
 * @date 2020/9/21 21:16
 * @since 0.0.1
 */
public  interface AbstractFactory {
    /**
     *  生产产品
     * @author morning
     * @date 2020/9/21 21:16
     * @since 0.0.1
     * @return IProduct
     */
    IProduct newProduct();
}
