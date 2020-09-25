package com.learning.designpattern.structural.flyweight;

/**
 *  concrete flyweight
 * @author morning
 * @date 2020/9/25 20:59
 * @since 0.0.1
 */
public class ConcreteFlyweight implements Flyweight {

    private String key;
    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("concrete flyweight ["+key+"] is created.");
    }

    /**
     * operation
     * @param state
     */
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println("concrete flyweight ["+key+"] is called.");
        System.out.println("unshared concrete flyweight ["+state.getInfo()+"] is called.");
    }
}
