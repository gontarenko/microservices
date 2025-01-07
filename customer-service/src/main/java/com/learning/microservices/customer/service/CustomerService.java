package com.learning.microservices.customer.service;

import com.learning.microservices.customer.controller.dto.CustomerRequest;
import com.learning.microservices.customer.domain.Customer;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequest request);

    List<Customer> getAll();
}
