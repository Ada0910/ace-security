package com.ada.auth.common.util;

import java.io.Serializable;

/**
 * @author Ada
 * @ClassName :JWTInfoUtil
 * @date 2019/10/11 21:53
 * @Description:
 */
public class JWTInfoUtil implements Serializable, IJWTInfoUtil {
    private String username;
    private String userId;
    private String name;

    public JWTInfoUtil(String username, String userId, String name) {
        this.username = username;
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String getUniqueName() {
        return username;
    }

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWTInfoUtil jwtInfoUtil = (JWTInfoUtil) o;
        if (username != null ? username.equals(jwtInfoUtil.username) : jwtInfoUtil.username != null) {
            return false;
        }
        return userId != null ? userId.equals(jwtInfoUtil.userId) : jwtInfoUtil.userId == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

}
