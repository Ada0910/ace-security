package com.ada.generator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * @Author Ada
 * @Date 16:33 2019/11/07
 * @Param
 * @return
 * @Description 资源映射类
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/admin/**").addResourceLocations(
                "classpath:/static/*");
        super.addResourceHandlers(registry);
    }

}
