package com.ada.server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:KeyConfiguration
 * @author: Ada
 * @date 2019/10/29 17:38
 * @Description: 加密配置类
 */
@Data
@Configuration
public class KeyConfiguration {
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}
