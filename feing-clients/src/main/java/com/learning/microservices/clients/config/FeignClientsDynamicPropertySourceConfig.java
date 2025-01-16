package com.learning.microservices.clients.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class FeignClientsDynamicPropertySourceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(Environment environment) {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

        String[] activeProfiles = environment.getActiveProfiles();

        for (String profile : activeProfiles) {
            if ("default".equals(profile)) {
                configurer.setLocation(new ClassPathResource("default.properties"));
                return configurer;
            } else if ("k8s".equals(profile)) {
                configurer.setLocation(new ClassPathResource("k8s.properties"));
                return configurer;
            }
        }

        throw new IllegalStateException("No default profile found in environment property sources");
//        configurer.setIgnoreResourceNotFound(true);
//        return configurer;
    }
}
