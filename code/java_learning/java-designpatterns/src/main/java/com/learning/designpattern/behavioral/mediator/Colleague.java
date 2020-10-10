package com.learning.designpattern.behavioral.mediator;

/**
 *  abstract colleague
 * @author morning
 * @date 2020/10/6 19:57
 * @since 0.0.1
 */
public abstract class Colleague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     *  abstract receive
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    public abstract void receive();

    /**
     *  abstract send
     * @author morning
     * @date 2020/10/6 19:59
     * @since 0.0.1
     */
    public abstract void send();
}
