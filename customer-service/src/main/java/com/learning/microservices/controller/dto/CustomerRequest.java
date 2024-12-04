package com.learning.microservices.controller.dto;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email
) {
}
