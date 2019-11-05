package com.ada.client.exception;

/**
 * @ClassName:JwtSignatureException
 * @author: Ada
 * @date 2019/11/05 16:59
 * @Description:
 */
public class JwtSignatureException extends Exception {
    public JwtSignatureException(String s) {
        super(s);
    }
}