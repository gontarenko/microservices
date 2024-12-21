package com.learning.microservices.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@Import(FeignTracingConfig.class)
@EnableFeignClients(
        basePackages = "com.learning.microservices.clients"
)
@SpringBootApplication
public class FraudServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(FraudServiceApp.class, args);
    }
}
