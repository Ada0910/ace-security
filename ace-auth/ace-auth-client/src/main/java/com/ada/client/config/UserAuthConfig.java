package com.ada.client.config;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ada
 * @ClassName :UserAuthConfig
 * @date 2019/10/10 22:02
 * @Description:
 */
public class UserAuthConfig {

    @Value("${auth.user.token-header}")
    private String tokenHeader;

    private byte[] pubKeyByte;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getToken(HttpServletRequest request) {
        return request.getHeader(this.getTokenHeader());
    }

    public byte[] getPubKeyByte() {
        return pubKeyByte;
    }

    public void setPubKeyByte(byte[] pubKeyByte) {
        this.pubKeyByte = pubKeyByte;
    }
}
