package com.learning.microservices.customer;


import com.learning.microservices.amqp.RabbitMQConfig;
import com.learning.microservices.clients.config.FeignClientConfig;
import com.learning.microservices.clients.config.FeignClientsDynamicPropertySourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import({RabbitMQConfig.class, FeignClientsDynamicPropertySourceConfig.class, FeignClientConfig.class})
@EnableFeignClients(
        basePackages = "com.learning.microservices.clients"
)
@SpringBootApplication
public class CustomerServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApp.class, args);
    }
}
