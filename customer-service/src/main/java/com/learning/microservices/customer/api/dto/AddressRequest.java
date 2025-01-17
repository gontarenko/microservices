package com.learning.microservices.customer.api.dto;

public record AddressRequest(
        Integer customerId,
        String street,
        String city,
        String state,
        String postalCode,
        String country
) {

}
