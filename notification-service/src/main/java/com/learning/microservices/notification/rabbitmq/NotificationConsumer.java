package com.learning.microservices.notification.rabbitmq;

import com.learning.microservices.clients.notification.dto.NotificationRequest;
import com.learning.microservices.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {
    private final NotificationService service;

    public NotificationConsumer(NotificationService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consume(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        service.send(notificationRequest);
    }
}
