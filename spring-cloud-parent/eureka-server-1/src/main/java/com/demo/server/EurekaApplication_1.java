package com.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication_1 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_1.class, args);
    }

}
