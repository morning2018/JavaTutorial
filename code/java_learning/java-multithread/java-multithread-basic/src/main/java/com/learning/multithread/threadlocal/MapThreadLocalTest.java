package com.learning.multithread.threadlocal;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *  map thread local
 * @author morning
 * @date 2020/10/16 21:47
 * @since 0.0.1
 */
public final class MapThreadLocalTest {

    private static final ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = new ThreadLocal() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static void set(String key, Object value) {
        MAP_THREAD_LOCAL.get().put(key, value);
    }

    public static Object get(String key) {
        if (MAP_THREAD_LOCAL.get() != null) {
            return MAP_THREAD_LOCAL.get().get(key);
        }
        return null;
    }

    public static void removeKey(String key) {
        if (MAP_THREAD_LOCAL.get() != null) {
            MAP_THREAD_LOCAL.get().remove(key);
        }
    }


    public static void print() {
        System.out.println("================map thread local start================");
        Map map = MAP_THREAD_LOCAL.get();
        if (map == null || map.isEmpty()) {
            System.out.println("MAP_THREAD_LOCAL has no data.");
        }
        else {
            for (Object key : map.keySet()) {
                System.out.println( key + ":" + map.get(key));
            }
        }
        System.out.println("================map thread local end================");
    }

    public static void remove() {
        MAP_THREAD_LOCAL.remove();
    }

}
