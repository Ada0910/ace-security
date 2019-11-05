package com.ada.client.exception;

/**
 * @ClassName:JwtTokenExpiredException
 * @author: Ada
 * @date 2019/11/05 17:00
 * @Description:
 */
public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}

