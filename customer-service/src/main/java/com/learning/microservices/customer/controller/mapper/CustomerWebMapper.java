package com.learning.microservices.customer.controller.mapper;

import com.learning.microservices.customer.controller.dto.CustomerDto;
import com.learning.microservices.customer.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerWebMapper {
    CustomerDto dto(Customer customer);

    List<CustomerDto> dtos(List<Customer> customers);

}
