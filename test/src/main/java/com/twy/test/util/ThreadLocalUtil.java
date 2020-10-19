package com.twy.test.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongpeng
 * @date 2020/10/19 19:49
 */
public class ThreadLocalUtil {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void put(String key, Object obj) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            map.put(key, obj);
        }
        threadLocal.set(map);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        return map != null ? map.get(key) : null;
    }

    public static void remove(String key) {
        Map<String, Object> map = threadLocal.get();
        map.remove(key);
    }

    public static void clear(String key) {
        threadLocal.remove();
    }

}
