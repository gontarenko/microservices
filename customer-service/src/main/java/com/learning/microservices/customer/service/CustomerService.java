package com.learning.microservices.customer.service;

import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequest request);

    List<Customer> getAll();

    boolean existsById(Integer customerId);

    void checkCustomerId(Integer id);

    Customer findById(Integer customerId);
}
