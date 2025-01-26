package com.learning.microservices.customer.service.mapper;

import com.learning.microservices.customer.api.dto.AddressRequest;
import com.learning.microservices.customer.domain.entity.Address;
import com.learning.microservices.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", source = "customer")
    void update(@MappingTarget Address address, AddressRequest request, Customer customer);
}
