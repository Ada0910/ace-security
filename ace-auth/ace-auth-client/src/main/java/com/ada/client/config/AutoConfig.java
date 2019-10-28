package com.ada.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:AutoConfig
 * @author: Ada
 * @date 2019/10/28 11:48
 * @Description:
 */
@Configuration
@ComponentScan({"com.ada.client", "com.ada.auth.common"})
public class AutoConfig {
    @Bean
    ServiceAuthConfig getServiceAuthConfig() {
        return new ServiceAuthConfig();
    }
    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }
}
