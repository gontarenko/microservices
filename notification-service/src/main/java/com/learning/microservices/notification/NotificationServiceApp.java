package com.learning.microservices.notification;

import com.learning.microservices.amqp.RabbitMQConfig;
import com.learning.microservices.amqp.RabbitMQMessageProducer;
import com.learning.microservices.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(FeignTracingConfig.class)
@Import(RabbitMQConfig.class)
@EnableFeignClients(
        basePackages = "com.learning.microservices.clients"
)
@SpringBootApplication
public class NotificationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish(
//                    "foo",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getIntervalNotificationRouteingKey()
//            );
//        };
//    }
}
