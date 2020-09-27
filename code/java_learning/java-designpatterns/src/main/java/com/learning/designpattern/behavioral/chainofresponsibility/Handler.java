package com.learning.designpattern.behavioral.chainofresponsibility;

/**
 *  abstract handler role
 * @author morning
 * @date 2020/9/27 20:59
 * @since 0.0.1
 */
public abstract class Handler {
    private Handler next;
    public void setNext(Handler handler) {
        this.next = next;
    }
    public Handler getNext() {
        return this.next;
    }

    /**
     * abstract handler request
     * @author morning
     * @date 2020/9/27 21:01
     * @since 0.0.1
     * @param request
     */
    public abstract void handlerRequest(String request);
}
