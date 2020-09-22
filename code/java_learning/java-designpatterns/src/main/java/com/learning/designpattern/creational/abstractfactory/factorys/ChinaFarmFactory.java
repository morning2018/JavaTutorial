package com.learning.designpattern.creational.abstractfactory.factorys;

import com.learning.designpattern.creational.abstractfactory.FarmFactory;
import com.learning.designpattern.creational.abstractfactory.IAnimal;
import com.learning.designpattern.creational.abstractfactory.IPlant;
import com.learning.designpattern.creational.abstractfactory.products.Horse;
import com.learning.designpattern.creational.abstractfactory.products.Potato;

public class ChinaFarmFactory implements FarmFactory {

    public IAnimal newAnimal() {
        return new Horse();
    }

    public IPlant newPlant() {
        return new Potato();
    }
}
