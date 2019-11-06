package com.ada.client.runner;

import com.ada.client.config.ServiceAuthConfig;
import com.ada.client.config.UserAuthConfig;
import com.ada.client.feign.ServiceAuthFeign;
import com.ada.common.response.BaseResponse;
import com.ada.common.response.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName:AuthClientRunner
 * @author: Ada
 * @date 2019/11/05 17:01
 * @Description:
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
        try {
            refreshUserPubKey();
        } catch (Exception e) {
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!", e);
        }
        log.info("初始化加载客户pubKey");
        try {
            refreshServicePubKey();
        } catch (Exception e) {
            log.error("初始化加载客户pubKey失败,1分钟后自动重试!", e);
        }
    }

    /**
     * 每一分钟刷新用户的公钥
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey() {
        BaseResponse resp = serviceAuthFeign.getUserPublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.userAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }

    /**
     * 每一分钟刷新client的公钥
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshServicePubKey() {
        BaseResponse resp = serviceAuthFeign.getServicePublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.serviceAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }


}
