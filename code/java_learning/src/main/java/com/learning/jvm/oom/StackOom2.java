package com.learning.jvm.oom;

import java.util.concurrent.TimeUnit;

/**
 * 多线程调用导致栈内存溢出：
 *
 * 参数设置：
 * -Xmx30M -Xms30M -Xss1M
 */
public class StackOom2 {
    static final int _1M = 1024*1024;
    public static void main(String[] args) {
        while(true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        byte[] b = new byte[_1M*1];
                    }
                }
            }).start();
        }
    }
}
