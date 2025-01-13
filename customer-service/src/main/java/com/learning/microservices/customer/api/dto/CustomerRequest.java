package com.learning.microservices.customer.api.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email
) {
}
