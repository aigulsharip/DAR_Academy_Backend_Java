package com.example.postdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PostDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostDiscoveryServerApplication.class, args);
    }

}
