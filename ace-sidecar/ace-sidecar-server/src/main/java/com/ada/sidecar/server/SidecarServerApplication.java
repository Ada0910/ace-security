package com.ada.sidecar.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class SidecarServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidecarServerApplication.class, args);
    }

}
