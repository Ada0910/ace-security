package com.ada.server.service.impl;

import com.ada.server.service.AuthService;
import com.ada.server.entity.JwtAuthenticationRequest;
import com.ada.server.util.user.JwtTokenUtil;
import org.springframework.stereotype.Service;

/**
 * @ClassName:AuthServiceImpl
 * @author: Ada
 * @date 2019/10/29 17:28
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        return null;
    }

    @Override
    public String refresh(String token) throws Exception {
        return null;
    }

    @Override
    public void validate(String token) throws Exception {

    }
}
