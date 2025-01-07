package com.learning.microservices.customer.service;

import com.learning.microservices.customer.controller.dto.CustomerRequest;
import com.learning.microservices.customer.domain.Customer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Customer> getAll() {
        throw new RuntimeException("not implemented");
    }
}
