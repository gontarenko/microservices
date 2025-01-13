package com.learning.microservices.customer.service.mapper;

import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Customer customer, CustomerRequest customerRegistatrationDto);
}
