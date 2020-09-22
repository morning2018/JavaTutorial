package com.learning.designpattern.creational.abstractfactory.products;

import com.learning.designpattern.creational.abstractfactory.IAnimal;

public class Cattle implements IAnimal {
    public void show() {
        System.out.println("cattle show");
    }
}
