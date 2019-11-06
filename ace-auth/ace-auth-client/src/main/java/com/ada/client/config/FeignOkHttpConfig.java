package com.ada.client.config;

import com.ada.client.interceptor.OkHttpTokenInterceptor;
import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:FeignOkHttpConfig
 * @author: Ada
 * @date 2019/11/05 16:46
 * @Description:
 */
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
public class FeignOkHttpConfig {
    @Autowired
    OkHttpTokenInterceptor okHttpLoggingInterceptor;

    //读超时时间
    private int feignOkHttpReadTimeout = 60;
    //连接超时时间
    private int feignConnectTimeout = 60;
    //写超时的时间
    private int feignWriteTimeout = 120;

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                //响应时间
                .readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
                //连接超时
                .connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
                //连接池
                .connectionPool(new ConnectionPool())
                //添加拦截
                .addInterceptor(okHttpLoggingInterceptor)
                .build();
    }
}
