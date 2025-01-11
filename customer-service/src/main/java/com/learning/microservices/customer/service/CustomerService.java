package com.learning.microservices.customer.service;

import com.learning.microservices.customer.api.dto.CustomerRegistatrationDto;
import com.learning.microservices.customer.store.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(CustomerRegistatrationDto request);

    List<Customer> getAll();
}
