package com.learning.microservices.fraud;

import com.learning.microservices.clients.config.FeignClientConfig;
import com.learning.microservices.clients.config.FeignClientsDynamicPropertySourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients(
        basePackages = "com.learning.microservices.clients"
)
@SpringBootApplication
@Import({FeignClientsDynamicPropertySourceConfig.class, FeignClientConfig.class})
public class FraudServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(FraudServiceApp.class, args);
    }
}
