package customer.service;

import com.learning.microservices.amqp.RabbitMQMessageProducer;
import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.clients.notification.dto.NotificationRequest;
import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.domain.entity.Customer;
import com.learning.microservices.customer.domain.repository.CustomerRepository;
import com.learning.microservices.customer.service.impl.CustomerServiceImpl;
import com.learning.microservices.customer.service.mapper.CustomerMapper;
import com.learning.microservices.customer.service.mapper.CustomerMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    CustomerRepository repository;
    @Mock
    FraudServiceClient fraudServiceClient;
    @Mock
    RabbitMQMessageProducer rabbitMessageProducer;

    @InjectMocks
    CustomerServiceImpl customerService;

    private CustomerMapper mapper = new CustomerMapperImpl();
    private Customer customer;
    private Customer customerInput;
    private FraudCheckResponse response = new FraudCheckResponse(false);
    private NotificationRequest notificationRequest;

    private VerificationMode verificationTimesOne = Mockito.times(1);

    @BeforeEach
    void setUp() {
        customer = new Customer(
                1,
                "Ivan",
                "Ivanov",
                "Ivanov@ivanov.ru"
        );
        customerInput = new Customer(
                null,
                "Ivan",
                "Ivanov",
                "Ivanov@ivanov.ru"
        );
        notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                "nice!"
        );
        ReflectionTestUtils.setField(customerService, "mapper", mapper);
    }

    @Test
    void saveNewCustomer_isOk() {
        // given
        CustomerRequest request = new CustomerRequest(
                "Ivan",
                "Ivanov",
                "Ivanov@ivanov.ru"
        );

        // when
        Mockito.when(repository.saveAndFlush(customerInput))
                .thenReturn(customer);
        Mockito.when(fraudServiceClient.isFraudster(customer.getId()))
                .thenReturn(response);
        Mockito.doNothing()
                .when(rabbitMessageProducer)
                .publish(notificationRequest,
                        "internal.exchange",
                        "internal.notification.routing-key"
                );

        // then
        customerService.save(request);
        Mockito.verify(repository, verificationTimesOne).saveAndFlush(customerInput);
        Mockito.verify(fraudServiceClient, verificationTimesOne).isFraudster(customer.getId());
        Mockito.verify(rabbitMessageProducer, verificationTimesOne).publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

    @Test
    void whenSaveFraudster_thenThrowException() {
    }
}