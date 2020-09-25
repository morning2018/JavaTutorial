package com.learning.designpattern.structural.flyweight;

import lombok.Data;

/**
 *  unshared concrete flyweight
 * @author morning
 * @date 2020/9/25 20:54
 * @since 0.0.1
 */
@Data
public class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

}
