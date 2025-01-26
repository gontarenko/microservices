package com.learning.microservices.customer.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {
    Integer id;
    Integer customerId;
    String street;
    String city;
    String state;
    String postalCode;
    String country;
}
