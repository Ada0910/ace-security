package com.ada.common.util;

import com.ada.common.context.BaseContextHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @author Ada
 * @ClassName :EntityUtil
 * @date 2019/10/3 16:45
 * @Description:
 */
public class EntityUtil {
    /**
     * 快速将bean的crtUser、crtHost、crtTime、updUser、updHost、updTime附上相关值
     */

    public static <T> void setCreateAndUpdateInfo(T entity) {
        setCreateInfo(entity);
        setUpdateInfo(entity);
    }

    /**
     * 快速将bean的crtUser、crtHost、crtTime附上相关值
     */
    public static <T> void setCreateInfo(T entity) {
        //service获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = "";
        String name = "";
        String hostIp = "";
        if (request != null) {
            id = StringUtils.trimToEmpty(request.getHeader("userId"));
            hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), ClientUtil.getClientIp(request));
            name = StringUtils.trimToEmpty(request.getHeader("userName"));
            name = URLDecoder.decode(name);
        }
        //isBlank判断某字符串是否为空或长度为0或由空白符(whitespace)构成
        if (StringUtils.isBlank(name)) {
            name = BaseContextHandler.getUserName();
        }
        if (StringUtils.isBlank(id)) {
            id = BaseContextHandler.getUserID();
        }

        // 默认属性
        String[] fields = {"crtName", "crtUser", "crtHost", "crtTime"};
        Field field = ReflectionUtil.getAccessibleField(entity, "crtTime");

        //默认值
        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }
        setDefaultValues(entity, fields, value);
    }

    /**
     * 快速将bean的updUser、updHost、updTime附上相关值
     */
    public static <T> void setUpdateInfo(T entity) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String hostIp = "";
        String name = "";
        String id = "";
        if (request != null) {
            hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), ClientUtil.getClientIp(request));
            name = StringUtils.trimToEmpty(request.getHeader("userName"));
            name = URLDecoder.decode(name);
            id = StringUtils.trimToEmpty(request.getHeader("userId"));
        }

        if (StringUtils.isBlank(name)) {
            name = BaseContextHandler.getUserName();
        }
        if (StringUtils.isBlank(id)) {
            id = BaseContextHandler.getUserID();
        }

        // 默认属性
        String[] fields = {"updName", "updUser", "updHost", "updTime"};
        Field field = ReflectionUtil.getAccessibleField(entity, "updTime");
        Object[] value = null;

        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }

        // 填充默认属性值
        setDefaultValues(entity, fields, value);
    }

    /**
     * 依据对象的属性数组和值数组对对象的属性进行赋值
     */
    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {

        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            if (ReflectionUtil.hasField(entity, field)) {
                ReflectionUtil.invokeSetter(entity, field, value[i]);
            }
        }
    }


}
