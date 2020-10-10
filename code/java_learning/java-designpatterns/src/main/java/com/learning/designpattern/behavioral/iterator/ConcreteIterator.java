package com.learning.designpattern.behavioral.iterator;

import java.util.List;

/**
 *  concrete Iterator
 * @author morning
 * @date 2020/10/6 20:36
 * @since 0.0.1
 */
public class ConcreteIterator implements Iterator {

    private List<Object> objectList = null;
    private int index = -1;
    public  ConcreteIterator(List<Object> objectList) {
        this.objectList = objectList;
    }

    /**
     * first element
     *
     * @return Object
     * @author morning
     * @date 2020/10/6 20:33
     * @since 0.0.1
     */
    @Override
    public Object first() {
        this.index = 0;
        return objectList.get(index);
    }

    /**
     * next element
     *
     * @return Object
     * @author morning
     * @date 2020/10/6 20:33
     * @since 0.0.1
     */
    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = this.objectList.get(++index);
        }
        return obj;
    }

    /**
     * has next element
     *
     * @return boolean
     * @author morning
     * @date 2020/10/6 20:34
     * @since 0.0.1
     */
    @Override
    public boolean hasNext() {
        if (index < objectList.size() - 1) {
            return true;
        }
        return false;
    }
}
