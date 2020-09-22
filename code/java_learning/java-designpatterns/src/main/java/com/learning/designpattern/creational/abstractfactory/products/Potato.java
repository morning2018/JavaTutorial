package com.learning.designpattern.creational.abstractfactory.products;

import com.learning.designpattern.creational.abstractfactory.IPlant;

public class Potato implements IPlant {
    public void show() {
        System.out.println("potato show");
    }
}
