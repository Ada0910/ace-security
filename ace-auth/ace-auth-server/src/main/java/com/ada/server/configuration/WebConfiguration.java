package com.ada.server.configuration;

import com.ada.common.handler.GlobalExceptionHandler;
import com.ada.server.interceptor.ServiceAuthRestInterceptor;
import com.ada.server.interceptor.UserAuthRestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName:WebConfiguration
 * @author: Ada
 * @date 2019/10/31 16:48
 * @Description:
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns("/service/**");
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/service/**");

    }
}
