package com.learning.microservices.customer.service.impl;

import com.learning.microservices.amqp.RabbitMQMessageProducer;
import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.clients.notification.dto.NotificationRequest;
import com.learning.microservices.customer.api.dto.CustomerRegistatrationDto;
import com.learning.microservices.customer.service.CustomerService;
import com.learning.microservices.customer.service.mapper.CustomerServiceMapper;
import com.learning.microservices.customer.store.entity.Customer;
import com.learning.microservices.customer.store.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;
    //    RestTemplate restTemplate;
    FraudServiceClient fraudServiceClient;
    //    NotificationClient notificationClient;
    RabbitMQMessageProducer rabbitMessageProducer;
    CustomerServiceMapper customerServiceMapper;
    // todo create and inject new CustomerMapper - СДЕЛАНО

    @Override
    public void save(CustomerRegistatrationDto request) {
        // todo create empty Customer - СДЕЛАНО
        // todo update empty Customer via new CustomerMapper (dont update id) - СДЕЛАНО
        Customer customer = customerServiceMapper.toEntity(request);
        // todo email validation
        // todo email not taken
        
        repository.saveAndFlush(customer);
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
