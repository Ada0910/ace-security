package com.ada.server.controller;

import com.ada.common.response.ObjectRestResponse;
import com.ada.server.entity.JwtAuthenticationRequest;
import com.ada.server.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ada
 * @ClassName :AuthController
 * @date 2019/9/27 22:10
 * @Description:
 */
@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    AuthService authService;

    /**
     * 创建认证的token(首页登录认证)
     */
    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        log.info("userName:"+authenticationRequest.getUsername() + " is require logging...");
        final String token = authService.login(authenticationRequest);
        return new ObjectRestResponse<>().data(token);
    }

    /**
     * 刷新
     */
    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new ObjectRestResponse<>().data(refreshedToken);
    }

    /**
     * 校验
     */
    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception {
        authService.validate(token);
        return new ObjectRestResponse<>();
    }
}
