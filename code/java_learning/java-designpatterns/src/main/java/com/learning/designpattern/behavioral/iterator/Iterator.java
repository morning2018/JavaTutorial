package com.learning.designpattern.behavioral.iterator;

/**
 *  Iterator interface
 * @author morning
 * @date 2020/10/6 20:32
 * @since 0.0.1
 */
public interface Iterator {
    /**
     *  first element
     * @author morning
     * @date 2020/10/6 20:33
     * @since 0.0.1
     * @return Object
     */
    Object first();

    /**
     *  next element
     * @author morning
     * @date 2020/10/6 20:33
     * @since 0.0.1
     * @return Object
     */
    Object next();
    
    /**
     *  has next element
     * @author morning
     * @date 2020/10/6 20:34
     * @since 0.0.1
     * @return boolean
     */
    boolean hasNext();
}
