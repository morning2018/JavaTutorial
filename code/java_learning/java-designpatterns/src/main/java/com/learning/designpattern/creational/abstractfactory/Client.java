package com.learning.designpattern.creational.abstractfactory;

import com.learning.designpattern.creational.abstractfactory.factorys.AmericaFarmFactory;
import com.learning.designpattern.creational.abstractfactory.factorys.ChinaFarmFactory;

public class Client {


    public static void main(String[] args) {
        FarmFactory farmFactory = new ChinaFarmFactory();
        farmFactory.newAnimal().show();
        farmFactory.newPlant().show();
        farmFactory = new AmericaFarmFactory();
        farmFactory.newAnimal().show();
        farmFactory.newPlant().show();
    }
}
