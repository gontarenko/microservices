package com.learning.microservices.customer.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerWebDto {
    Integer id;
    String email;
    String fullName;
    // todo add String fullName (concat firstName + lastName) via MapStruct - СДЕЛАНО


    public CustomerWebDto(Integer id, String email, String fullName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }

    public CustomerWebDto(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public CustomerWebDto() {
    }
}
