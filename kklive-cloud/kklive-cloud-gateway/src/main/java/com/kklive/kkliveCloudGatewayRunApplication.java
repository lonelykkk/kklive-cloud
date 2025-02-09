package com.kklive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.kklive"})
public class kkliveCloudGatewayRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(kkliveCloudGatewayRunApplication.class, args);
    }
}
