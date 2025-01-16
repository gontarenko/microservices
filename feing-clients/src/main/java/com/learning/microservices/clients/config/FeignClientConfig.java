package com.learning.microservices.clients.config;

import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.notification.NotificationClient;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignClientConfig {

    @Value("${feign-clients.fraud.url}")
    private String fraudClientUrl;
    @Value("${feign-clients.notification.url}")
    private String notificationClientUrl;

    @Bean
    public FraudServiceClient fraudClient() {
        fraudClientUrl += "/" + FraudServiceClient.PATH;
        log.info("fraudClientUrl: {}", fraudClientUrl);
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .target(FraudServiceClient.class, fraudClientUrl);
    }

    @Bean
    public NotificationClient notificationClient() {
        notificationClientUrl += "/" + NotificationClient.PATH;
        log.info("notificationClientUrl: {}", notificationClientUrl);
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .target(NotificationClient.class, notificationClientUrl);
    }
}