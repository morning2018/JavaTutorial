package com.learning.designpattern.behavioral.state;

/**
 *  abstract state
 * @author morning
 * @date 2020/9/29 21:44
 * @since 0.0.1
 */
public abstract class State {
    /**
     *  handle
     * @author morning
     * @date 2020/9/29 21:49
     * @since 0.0.1
     * @param context
     */
    public abstract void handle(Context context);
}
