package com.learning.microservices.customer.api.mapper;

import com.learning.microservices.customer.api.dto.AddressDto;
import com.learning.microservices.customer.domain.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AddressWebMapper {
    @Mapping(target = "customerId", source = "customerId")
    AddressDto dto(Address address);

    List<AddressDto> dtos(List<Address> addresses);

}
