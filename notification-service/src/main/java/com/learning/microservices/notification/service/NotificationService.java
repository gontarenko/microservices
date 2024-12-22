package com.learning.microservices.notification.service;

import com.learning.microservices.clients.notification.dto.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest request);
}
