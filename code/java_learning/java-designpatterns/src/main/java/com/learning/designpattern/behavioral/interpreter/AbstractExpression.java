package com.learning.designpattern.behavioral.interpreter;

/**
 *  abstract expression role
 * @author morning
 * @date 2020/10/6 21:44
 * @since 0.0.1
 */
public interface AbstractExpression {
    /**
     * interpret
     * @author morning
     * @date 2020/10/6 21:47
     * @since 0.0.1
     * @param info :info
     * @return  Object
     */
    public Object interpret(String info);
}
