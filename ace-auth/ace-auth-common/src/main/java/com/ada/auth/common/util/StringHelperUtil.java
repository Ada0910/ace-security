package com.ada.auth.common.util;

/**
 * @ClassName:StringHelper
 * @author: Ada
 * @date 2019/10/11 16:38
 * @Description:
 */
public class StringHelperUtil {
    public static String getObjectValue(Object object){
        return object== null?"":object.toString();
    }
}
