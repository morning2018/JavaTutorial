package com.learning.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 *  flyweight factory
 * @author morning
 * @date 2020/9/25 21:02
 * @since 0.0.1
 */
public class FlyweightFactory {
    private Map<String, Flyweight> flyweightMap = new HashMap<String, Flyweight>();
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (flyweight != null) {
            System.out.println("concrete flyweight :" + key + "exists, get it successfully.");
        }
        else {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key, flyweight);
        }
        return flyweight;
    }
}
