package com.ada.common.util;

/**
 * @ClassName:StringHelperUtil
 * @author: Ada
 * @date 2019/10/23 16:28
 * @Description:
 */
public class StringHelperUtil {
    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}