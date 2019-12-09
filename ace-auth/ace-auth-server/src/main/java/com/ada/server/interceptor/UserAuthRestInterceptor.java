package com.ada.server.interceptor;

import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.common.context.BaseContext;
import com.ada.server.configuration.UserConfiguration;
import com.ada.server.util.user.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:UserAuthRestInterceptor
 * @author: Ada
 * @date 2019/10/31 17:04
 * @Description:
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserConfiguration userConfiguration;

    /**
     * 预处理回调方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String token = request.getHeader(userConfiguration.getUserTokenHeader());
        IJWTInfoUtil infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        BaseContext.setUsername(infoFromToken.getUniqueName());
        BaseContext.setName(infoFromToken.getName());
        BaseContext.setUserID(infoFromToken.getId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
