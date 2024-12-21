package com.learning.microservices.customer.service;

import com.learning.microservices.customer.controller.dto.CustomerRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Для учебной цели, проверки как работает @Primary
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl2 implements CustomerService {

    @Override
    public void save(CustomerRequest request) {
        throw new RuntimeException("not implemented");
    }
}
