package com.learning.designpattern.proxy;

/**
 *  客户端
 * @author morning
 * @date 2020/9/20 19:27
 * @since 0.0.1
 */
public class ProxyClient {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
