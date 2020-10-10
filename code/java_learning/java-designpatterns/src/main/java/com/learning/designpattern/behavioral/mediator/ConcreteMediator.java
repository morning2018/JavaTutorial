package com.learning.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 *  concrete mediator
 * @author morning
 * @date 2020/10/6 19:56
 * @since 0.0.1
 */
public class ConcreteMediator extends  Mediator {
    private List<Colleague> colleagues = new ArrayList<>();
    /**
     *  concrete mediator register
     *
     * @param colleague
     * @author morning
     * @date 2020/10/6 20:00
     * @since 0.0.1
     */
    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    /**
     * abstract relay
     *
     * @param colleague
     * @author morning
     * @date 2020/10/6 20:01
     * @since 0.0.1
     */
    @Override
    public void relay(Colleague colleague) {
        for (Colleague c : colleagues) {
            if (!c.equals(colleague)) {
                c.receive();
            }
        }
    }
}
