package com.ada.server.service;

import java.util.List;

/**
 * @ClassName:AuthClientService
 * @author:Ada
 * @date 2019/10/3011:01
 * @Description:客户端认证类
 */
public interface AuthClientService {
    public String apply(String clientId, String secret) throws Exception;

    /**
     * 获取授权的客户端列表
     */
    public List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 获取服务授权的客户端列表
     */
    public List<String> getAllowedClient(String serviceId);

    public void registryClient();

    /**
     * 校验
     */
    public void validate(String clientId, String secret) throws Exception;

}
