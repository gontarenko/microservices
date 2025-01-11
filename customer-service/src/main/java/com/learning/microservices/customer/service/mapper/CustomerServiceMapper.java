package com.learning.microservices.customer.service.mapper;

import com.learning.microservices.customer.api.dto.CustomerRegistatrationDto;
import com.learning.microservices.customer.api.dto.CustomerWebDto;
import com.learning.microservices.customer.store.entity.Customer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerServiceMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerRegistatrationDto customerRegistatrationDto);

    @AfterMapping
    default void setFullName(Customer customer,
                             @MappingTarget CustomerWebDto customerWebDto) {
        customerWebDto.setFullName(customer.getFirstName()
                + " "
                + customer.getLastName()
        );
    }
}
