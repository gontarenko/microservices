package com.learning.microservices.customer.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Integer id;
    String email;
    String fullName;
}
