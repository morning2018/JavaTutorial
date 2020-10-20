package com.learning.multithread.threadlocal;

/**
 *  ThreadLocal of string
 * @author morning
 * @date 2020/10/16 21:23
 * @since 0.0.1
 */
public final class StringThreadLocalTest {
    private static final ThreadLocal<String> STRING_THREAD_LOCAL = new ThreadLocal<>();

    public static String get() {
        return STRING_THREAD_LOCAL.get();
    }

    public static void set(String str) {
        STRING_THREAD_LOCAL.set(str);
    }
}
