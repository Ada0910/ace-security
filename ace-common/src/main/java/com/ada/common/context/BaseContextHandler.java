package com.ada.common.context;

import com.ada.common.constant.CommonConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ada
 * @ClassName :BaseContextHandler
 * @date 2019/10/3 20:11
 * @Description:
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static String getUserName() {
        Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }

    public static String getUserID() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }
}

