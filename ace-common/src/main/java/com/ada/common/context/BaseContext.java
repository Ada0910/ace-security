package com.ada.common.context;

import com.ada.common.constant.CommonConstant;
import com.ada.common.util.StringHelperUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Ada
 * @ClassName :BaseContext
 * @date 2019/10/3 20:11
 * @Description: 公共的内容处理程序
 */
public class BaseContext {
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

    public static String getUsername() {
        Object value = get(CommonConstant.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }

    public static String getUserID() {
        Object value = get(CommonConstant.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getToken() {
        Object value = get(CommonConstant.CONTEXT_KEY_USER_TOKEN);
        return StringHelperUtil.getObjectValue(value);
    }

    public static void setToken(String token) {
        set(CommonConstant.CONTEXT_KEY_USER_TOKEN, token);
    }

    public static void setName(String name) {
        set(CommonConstant.CONTEXT_KEY_USER_NAME, name);
    }

    public static void setUserID(String userID) {
        set(CommonConstant.CONTEXT_KEY_USER_ID, userID);
    }

    public static void setUsername(String userName) {
        set(CommonConstant.CONTEXT_KEY_USERNAME, userName);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContextVariable() throws InterruptedException {
            BaseContext.set("test", "main");
            new Thread(() -> {
                BaseContext.set("test", "moo");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContext.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(() -> {
                BaseContext.set("test", "moo2");
                assertEquals(BaseContext.get("test"), "moo2");
                logger.info("thread two done!");
            }).start();

            Thread.sleep(5000);
            assertEquals(BaseContext.get("test"), "main");
            logger.info("main one done!");
        }

        @Test
        public void testSetUserInfo() {
            BaseContext.setUserID("test");
            assertEquals(BaseContext.getUserID(), "test");
            BaseContext.setUsername("test2");
            assertEquals(BaseContext.getUsername(), "test2");
        }
    }
}

