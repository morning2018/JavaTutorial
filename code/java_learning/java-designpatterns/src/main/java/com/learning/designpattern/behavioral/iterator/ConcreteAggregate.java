package com.learning.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *  concrete aggregate
 * @author morning
 * @date 2020/10/6 20:30
 * @since 0.0.1
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    /**
     * add element
     *
     * @param object
     * @author morning
     * @date 2020/10/6 20:28
     * @since 0.0.1
     */
    @Override
    public void add(Object object) {
        list.add(object);
    }

    /**
     * remove element
     *
     * @param object
     * @author morning
     * @date 2020/10/6 20:29
     * @since 0.0.1
     */
    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    /**
     * get iterator
     *
     * @return Iterable
     * @author morning
     * @date 2020/10/6 20:29
     * @since 0.0.1
     */
    @Override
    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}
