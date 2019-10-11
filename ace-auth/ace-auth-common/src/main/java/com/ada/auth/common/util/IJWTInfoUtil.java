package com.ada.auth.common.util;

/**
 * @author Ada
 * @ClassName :IJWTInfoUtil
 * @date 2019/10/10 23:28
 * @Description:
 */
public interface IJWTInfoUtil {
    /**
     * 获取用户名
     */
    String getUniqueName();

    /**
     * 获取用户ID
     */
    String getId();

    /**
     * 获取名称
     */
    String getName();
}
