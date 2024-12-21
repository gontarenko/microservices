package com.learning.microservices.service;

import com.learning.microservices.clients.notification.dto.SendNotificationRequest;

public interface NotificationService {
    void send(SendNotificationRequest request);
}
