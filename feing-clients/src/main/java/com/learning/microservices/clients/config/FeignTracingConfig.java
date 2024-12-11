package com.learning.microservices.clients.config;

import feign.Feign;
import feign.RequestInterceptor;
import io.micrometer.tracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
//public class FeignTracingConfig {

//    @Autowired
//    private Tracer tracer;
//
//    @Bean
//    public RequestInterceptor tracingInterceptor() {
//        return requestTemplate -> {
//            // Добавляем текущий traceId и spanId в заголовки запроса
//            if (tracer.currentSpan() != null) {
//                System.out.println("using RequestInterceptor");
////                requestTemplate.header("traceId", tracer.currentSpan().context().traceId());
//                System.out.println("traceId = " + tracer.currentSpan().context().traceId());
////                requestTemplate.header("spanId", tracer.currentSpan().context().spanId());
//                System.out.println("spanId = " + tracer.currentSpan().context().spanId());
//            }
//        };
//    }
//
//    @Bean
//    public Feign.Builder feignBuilder() {
//        System.out.println("feignBuilder configuring");
//        // Micrometer автоматически добавляет заголовки трассировки
//        return Feign.builder();
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        System.out.println("configuring RestTemplate");
//        return builder.build(); // Micrometer автоматически добавит нужные заголовки
//    }
//}