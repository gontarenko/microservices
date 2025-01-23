package com.learning.microservices.customer.service;

import com.learning.microservices.customer.api.dto.AddressRequest;
import com.learning.microservices.customer.domain.entity.Address;
import com.learning.microservices.customer.domain.entity.Customer;

import java.util.List;

public interface AddressService {
    void save(AddressRequest request, Integer customerId);

    List<Address> getAll();

    void deleteById(Integer id);

    Address findById(Integer id);

    void updateById(Integer id, AddressRequest request);
}
