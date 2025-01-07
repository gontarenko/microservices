package com.learning.microservices.customer.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Integer id;
    String email;

    public CustomerDto(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public CustomerDto() {
    }
}
