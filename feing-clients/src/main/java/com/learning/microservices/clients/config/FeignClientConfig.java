package com.learning.microservices.clients.config;

import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.notification.NotificationClient;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Value("${feign-clients.fraud.url}")
    private String fraudClientUrl;
    @Value("${feign-clients.notification.url}")
    private String notificationClientUrl;

    @Bean
    public FraudServiceClient fraudClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .target(FraudServiceClient.class, fraudClientUrl);
    }

    @Bean
    public NotificationClient notificationClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .target(NotificationClient.class, notificationClientUrl);
    }
}