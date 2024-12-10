package com.learning.microservices.service;

import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.controller.dto.CustomerRequest;
import com.learning.microservices.domain.Customer;
import com.learning.microservices.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Primary
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;
    RestTemplate restTemplate;
    FraudServiceClient fraudServiceClient;

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
        FraudCheckResponse response = fraudServiceClient.isFraudster(customer.getId());
        return response.fraudster();
    }

//    private boolean isFraudster(Customer customer) {
//        String urlTemplate = "http://fraud-service/api/v1/fraud-check?customerId=%s";
//        FraudCheckResponse response = restTemplate.getForObject(urlTemplate.formatted(customer.getId()), FraudCheckResponse.class);
//        return response.fraudster();
//    }
}
