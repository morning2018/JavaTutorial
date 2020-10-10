package com.learning.designpattern.behavioral.visitor;

/**
 *  abstract element role
 * @author morning
 * @date 2020/10/6 20:52
 * @since 0.0.1
 */
public interface Element {
    /**
     *  accept visitor
     * @author morning
     * @date 2020/10/6 20:52
     * @since 0.0.1
     * @param visitor
     */
    void accept(Visitor visitor);
}
