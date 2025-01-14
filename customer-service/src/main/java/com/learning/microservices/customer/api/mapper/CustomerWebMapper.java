package com.learning.microservices.customer.api.mapper;

import com.learning.microservices.customer.api.dto.CustomerWebDto;
import com.learning.microservices.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CustomerWebMapper {
    @Mapping(target = "fullName", source = "fullName")
    CustomerWebDto dto(Customer customer);

    List<CustomerWebDto> dtos(List<Customer> customers);
}
