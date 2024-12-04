package com.learning.microservices.service;

import com.learning.microservices.controller.dto.CustomerRequest;
import com.learning.microservices.domain.Customer;
import com.learning.microservices.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;

    @Override
    public void save(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo email validation
        // todo email not taken
        repository.save(customer);
    }
}
