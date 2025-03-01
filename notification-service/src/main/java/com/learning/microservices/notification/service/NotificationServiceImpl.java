package com.learning.microservices.notification.service;

import com.learning.microservices.clients.notification.dto.NotificationRequest;
import com.learning.microservices.notification.domain.Notification;
import com.learning.microservices.notification.repository.NotificationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationServiceImpl implements NotificationService {
    NotificationRepository repository;

    @Override
    public void send(NotificationRequest request) {
        repository.save(new Notification(
                request.toCustomerId(),
                request.toCustomerEmail(),
                "customer-service",
                request.message(),
                LocalDateTime.now()
        ));
    }
}
