package com.learning.designpattern.behavioral.iterator;

/**
 *  aggregate interface
 * @author morning
 * @date 2020/10/6 20:27
 * @since 0.0.1
 */
public interface Aggregate {
    /**
     *  add element
     * @author morning
     * @date 2020/10/6 20:28
     * @since 0.0.1
     * @param object
     */
    public void add(Object object);

    /**
     *  remove element
     * @author morning
     * @date 2020/10/6 20:29
     * @since 0.0.1
     * @param object
     */
    public void remove(Object object);

    /**
     *  get iterator
     * @author morning
     * @date 2020/10/6 20:29
     * @since 0.0.1
     * @return Iterable
     */
    public Iterator getIterator();
}
