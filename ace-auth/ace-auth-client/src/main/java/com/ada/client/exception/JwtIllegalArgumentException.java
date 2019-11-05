package com.ada.client.exception;

/**
 * @ClassName:JwtIllegalArgumentException
 * @author: Ada
 * @date 2019/11/05 16:59
 * @Description:
 */
public class JwtIllegalArgumentException extends Exception {
    public JwtIllegalArgumentException(String s) {
        super(s);
    }
}