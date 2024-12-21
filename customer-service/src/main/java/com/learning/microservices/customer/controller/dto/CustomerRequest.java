package com.learning.microservices.customer.controller.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email
) {
}
