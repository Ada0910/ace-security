package com.ada.server.interceptor;

import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.common.exception.auth.ClientForbiddenException;
import com.ada.server.configuration.ClientConfiguration;
import com.ada.server.service.AuthClientService;
import com.ada.server.util.client.ClientTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:ServiceAuthRestInterceptor
 * @author: Ada
 * @date 2019/10/31 16:59
 * @Description: 需要在addInterceptors（）方法里面添加方可以生效
 */
@SuppressWarnings("ALL")
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(ServiceAuthRestInterceptor.class);
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private AuthClientService authClientService;
    @Autowired
    private ClientConfiguration clientConfiguration;

    /**
     * 预处理回调方法（先判断client的token信息是否在授权的客户端列表中）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取用户的token
        String token = request.getHeader(clientConfiguration.getClientTokenHeader());
        //从token中拿到用户的信息
        IJWTInfoUtil infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        //判断Client是否在授权的客户端列表里面
        for (String client : authClientService.getAllowedClient(clientConfiguration.getClientId())) {
            if (client.equals(uniqueName)) {
                return super.preHandle(request, response, handler);
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
