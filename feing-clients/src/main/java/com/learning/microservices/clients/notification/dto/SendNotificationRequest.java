package com.learning.microservices.clients.notification.dto;

public record SendNotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
) {
}
