package com.learning.microservices;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerServiceConfig {

//    @Bean("loadBalancedRestTemplate")
//    @LoadBalanced
//    public RestTemplate customerService() {
//        return new RestTemplate();
//    }
}
