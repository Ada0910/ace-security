package com.ada.server.service;

import com.ada.server.entity.JwtAuthenticationRequest;

/**
 * @ClassName:AuthService
 * @author: Ada
 * @date 2019/10/29 17:05
 * @Description:
 */
public interface AuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;

    String refresh(String token) throws Exception;

    void validate(String token) throws Exception;
}
