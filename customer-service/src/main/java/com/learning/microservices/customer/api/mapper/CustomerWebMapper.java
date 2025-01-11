package com.learning.microservices.customer.api.mapper;

import com.learning.microservices.customer.api.dto.CustomerWebDto;
import com.learning.microservices.customer.store.entity.Customer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerWebMapper {
    CustomerWebDto dto(Customer customer);

    List<CustomerWebDto> dtos(List<Customer> customers);

    @AfterMapping
    default void setFullName(Customer customer,
                             @MappingTarget CustomerWebDto customerWebDto) {
        customerWebDto.setFullName(customer.getFirstName()
                + " "
                + customer.getLastName()
        );
    }
}
