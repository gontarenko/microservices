package com.learning.microservices.customer.service.impl;

import com.learning.microservices.customer.api.dto.CustomerRegistatrationDto;
import com.learning.microservices.customer.service.CustomerService;
import com.learning.microservices.customer.store.entity.Customer;
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
public class CustomerServiceImplTest implements CustomerService {

    @Override
    public void save(CustomerRegistatrationDto request) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public List<Customer> getAll() {
        throw new RuntimeException("not implemented");
    }
}
