package com.ada.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName:JwtAuthenticationRequest
 * @author: Ada
 * @date 2019/10/29 17:10
 * @Description:用户密码
 */
@Getter
@Setter
public class JwtAuthenticationRequest {
    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JwtAuthenticationRequest() {
    }
}
