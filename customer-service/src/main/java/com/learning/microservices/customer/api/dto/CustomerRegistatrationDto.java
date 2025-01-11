package com.learning.microservices.customer.api.dto;

public record CustomerRegistatrationDto(
        String firstName,
        String lastName,
        String email
) {
}
