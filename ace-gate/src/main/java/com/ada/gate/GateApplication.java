package com.ada.gate;

import com.ada.client.EnableAceAuthClient;
import com.ada.gate.util.DBLogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAceAuthClient
@EnableFeignClients({"com.ada.client.feign", "com.ada.gate.feign"})
public class GateApplication {
    public static void main(String[] args) {
        DBLogUtil.getInstance().start();
        SpringApplication.run(GateApplication.class, args);
    }

}
