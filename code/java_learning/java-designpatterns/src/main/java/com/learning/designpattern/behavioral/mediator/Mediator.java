package com.learning.designpattern.behavioral.mediator;

/**
 *  abstract mediator
 * @author morning
 * @date 2020/10/6 19:55
 * @since 0.0.1
 */
public abstract  class Mediator {
    /**
     *  abstract register
     * @author morning
     * @date 2020/10/6 20:00
     * @since 0.0.1
     * @param colleague
     */
    public abstract void register(Colleague colleague);

    /**
     * abstract relay
     * @author morning
     * @date 2020/10/6 20:01
     * @since 0.0.1
     * @param colleague
     */
    public abstract void relay(Colleague colleague);
}
