package com.learning.designpattern.behavioral.state;
/**
 *  client
 * @author morning
 * @date 2020/9/29 21:54
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        // create evn
        Context context = new Context();
        // handle request
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}
