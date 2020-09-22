package com.learning.designpattern.creational.abstractfactory;

public interface FarmFactory {
    public IAnimal newAnimal();
    public IPlant newPlant();
}
