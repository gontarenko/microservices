package com.learning.microservices.customer.service.impl;

import com.learning.microservices.customer.api.dto.AddressRequest;
import com.learning.microservices.customer.domain.entity.Address;
import com.learning.microservices.customer.domain.entity.Customer;
import com.learning.microservices.customer.domain.repository.AddressRepository;
import com.learning.microservices.customer.service.AddressService;
import com.learning.microservices.customer.service.CustomerService;
import com.learning.microservices.customer.service.mapper.AddressMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    private final CustomerService customerService;

    @Autowired
    public AddressServiceImpl(AddressRepository repository, AddressMapper mapper, CustomerService customerService) {
        this.repository = repository;
        this.mapper = mapper;
        this.customerService = customerService;
    }


    @Override
    public void save(AddressRequest request, Integer customerId) {
        Integer id = request.customerId();
        customerService.checkCustomerId(id);
        Customer customer = customerService.findById(id);

        Address address = new Address();
        mapper.update(address, request, customer);
        log.info("Create address: {}", address);
        repository.saveAndFlush(address);
        log.info("Address saved successfully.");
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Address findById(Integer id) {
        Optional<Address> optional = repository.findById(id);
        return optional.get();
    }

    @Override
    public void updateById(Integer id, AddressRequest request) {
        Optional<Address> existingAddress = repository.findById(id);
        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();
            Customer customer = customerService.findById(request.customerId());
            address.setCustomer(customer);
            address.setStreet(request.street());
            address.setCity(request.city());
            address.setState(request.state());
            address.setPostalCode(request.postalCode());
            address.setCountry(request.country());

            repository.save(address);
        } else {
            throw new EntityNotFoundException("Address with ID " + id + " not found");
        }
    }
}
