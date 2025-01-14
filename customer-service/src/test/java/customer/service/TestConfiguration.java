package customer.service;

import com.learning.microservices.customer.service.mapper.CustomerMapper;
import com.learning.microservices.customer.service.mapper.CustomerMapperImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {
    @Bean
    CustomerMapper customerMapper() {
        return new CustomerMapperImpl();
    }
}
