package com.learning.microservices.service;

import com.learning.microservices.controller.dto.CustomerRequest;
import com.learning.microservices.domain.Customer;
import com.learning.microservices.repository.CustomerRepository;
import com.learning.microservices.service.dto.FraudCheckResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Primary
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

        repository.saveAndFlush(customer);
        if (isFraudster(customer)) {
            throw new IllegalStateException("fraudster");
        }

        // todo send notification
    }

    private boolean isFraudster(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();
        String urlTemplate = "http://localhost:8081/api/v1/fraud-check?customerId=%s";
        FraudCheckResponse response = restTemplate.getForObject(urlTemplate.formatted(customer.getId()), FraudCheckResponse.class);
        return response.fraudster();
    }
}
