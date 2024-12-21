package com.learning.microservices.customer.service;

import com.learning.microservices.customer.controller.dto.CustomerRequest;

public interface CustomerService {
    void save(CustomerRequest request);
}
