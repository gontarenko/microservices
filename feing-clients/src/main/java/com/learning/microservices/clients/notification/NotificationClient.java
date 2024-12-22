package com.learning.microservices.clients.notification;

import com.learning.microservices.clients.notification.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification-service", path = NotificationClient.PATH)
public interface NotificationClient {
    String PATH = "api/v1/notifications";


    @PostMapping
    void send(@RequestBody NotificationRequest request);
}
