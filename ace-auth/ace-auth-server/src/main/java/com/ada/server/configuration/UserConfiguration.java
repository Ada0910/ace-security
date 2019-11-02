package com.ada.server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:UserConfiguration
 * @author: Ada
 * @date 2019/10/31 16:47
 * @Description: 用户配置类
 */
@Configuration
@Data
public class UserConfiguration {
    @Value("${jwt.token-header}")
    private String userTokenHeader;
}
