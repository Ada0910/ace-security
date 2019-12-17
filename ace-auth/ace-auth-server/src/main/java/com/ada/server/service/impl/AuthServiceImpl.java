package com.ada.server.service.impl;

import com.ada.api.vo.user.UserInfo;
import com.ada.auth.common.util.JWTInfoUtil;
import com.ada.common.exception.auth.UserInvalidException;
import com.ada.server.entity.JwtAuthenticationRequest;
import com.ada.server.feign.IUserServiceFeign;
import com.ada.server.service.AuthService;
import com.ada.server.util.user.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private IUserServiceFeign userService;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserServiceFeign userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    /**
     * 通过用户名和密码登录验证
     */
    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        //验证用户名和密码是否正确
        UserInfo info = userService.validate(authenticationRequest);
        //生成包含用户信息下token
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfoUtil(info.getUsername(), info.getId() + "", info.getName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }


    @Override
    public String refresh(String token) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(token));

    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }
}
