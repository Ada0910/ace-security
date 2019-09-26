package com.ada.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@MapperScan("com.ada.server.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoConfiguration*/
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
