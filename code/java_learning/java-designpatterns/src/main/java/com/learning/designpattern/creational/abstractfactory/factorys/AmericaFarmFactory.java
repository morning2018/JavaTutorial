package com.learning.designpattern.creational.abstractfactory.factorys;

import com.learning.designpattern.creational.abstractfactory.FarmFactory;
import com.learning.designpattern.creational.abstractfactory.IAnimal;
import com.learning.designpattern.creational.abstractfactory.IPlant;
import com.learning.designpattern.creational.abstractfactory.products.Cattle;
import com.learning.designpattern.creational.abstractfactory.products.Tomato;

public class AmericaFarmFactory implements FarmFactory {
    public IAnimal newAnimal() {
        return new Cattle();
    }

    public IPlant newPlant() {
        return new Tomato();
    }
}
