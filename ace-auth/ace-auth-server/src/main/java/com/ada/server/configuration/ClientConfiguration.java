package com.ada.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:ClientConfiguration
 * @author: Ada
 * @date 2019/10/30 10:59
 * @Description:
 */
@Configuration
public class ClientConfiguration {
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;
    @Value("${client.token-header}")
    private String clientTokenHeader;

    public String getClientTokenHeader() {
        return clientTokenHeader;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientId() {
        return clientId;
    }
}
