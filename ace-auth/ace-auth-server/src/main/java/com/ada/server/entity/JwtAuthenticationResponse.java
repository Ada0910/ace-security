package com.ada.server.entity;

import java.io.Serializable;

/**
 * @ClassName:JwtAuthenticationResponse
 * @author: Ada
 * @date 2019/10/31 17:13
 * @Description:
 */
public class JwtAuthenticationResponse implements Serializable {

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
