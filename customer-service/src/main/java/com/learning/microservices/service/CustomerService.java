package com.learning.microservices.service;

import com.learning.microservices.controller.dto.CustomerRequest;

public interface CustomerService {
    void save(CustomerRequest request);
}
