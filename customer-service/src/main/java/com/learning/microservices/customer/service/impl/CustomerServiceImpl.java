package com.learning.microservices.customer.service.impl;

import com.learning.microservices.amqp.RabbitMQMessageProducer;
import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.clients.notification.dto.NotificationRequest;
import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.api.exception.CustomerNotFoundException;
import com.learning.microservices.customer.domain.entity.Customer;
import com.learning.microservices.customer.domain.repository.CustomerRepository;
import com.learning.microservices.customer.service.CustomerService;
import com.learning.microservices.customer.service.mapper.CustomerMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;
    //    RestTemplate restTemplate;
    FraudServiceClient fraudServiceClient;
    //    NotificationClient notificationClient;
    RabbitMQMessageProducer rabbitMessageProducer;
    CustomerMapper mapper;

    @Override
    public void save(CustomerRequest request) {
        Customer customer = new Customer();
        mapper.update(customer, request);
        // todo email validation
        // todo email not taken

        customer = repository.saveAndFlush(customer);
        if (isFraudster(customer)) {
            throw new IllegalStateException("fraudster");
        }

        rabbitMessageProducer.publish(
                new NotificationRequest(customer.getId(), customer.getEmail(), "nice!"),
                "internal.exchange",
                "internal.notification.routing-key"
        );
//        notificationClient.send(new SendNotificationRequest(customer.getId(), customer.getEmail(), "nice!"));
    }


    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(Integer customerId) {
        return repository.existsById(customerId);
    }

    @Override
    public Customer findById(Integer customerId) {
        Optional<Customer> optional = repository.findById(customerId);
        return optional.get();
    }

    private boolean isFraudster(Customer customer) {
        FraudCheckResponse response = fraudServiceClient.isFraudster(customer.getId());
        return response.fraudster();
    }

    public void checkCustomerId(Integer id) {
        log.info("Checking the existence of the customer_id");
        if (!existsById(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        log.info("Customer with ID {} exists", id);
    }

//    private boolean isFraudster(Customer customer) {
//        String urlTemplate = "http://fraud-service/api/v1/fraud-check?customerId=%s";
//        FraudCheckResponse response = restTemplate.getForObject(urlTemplate.formatted(customer.getId()), FraudCheckResponse.class);
//        return response.fraudster();
//    }
}
