package com.learning.microservices.customer.api.controller;

import com.learning.microservices.customer.api.dto.AddressDto;
import com.learning.microservices.customer.api.dto.AddressRequest;
import com.learning.microservices.customer.api.exception.CustomerNotFoundException;
import com.learning.microservices.customer.api.mapper.AddressWebMapper;
import com.learning.microservices.customer.domain.entity.Address;
import com.learning.microservices.customer.domain.entity.Customer;
import com.learning.microservices.customer.service.AddressService;
import com.learning.microservices.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/address")
public class AddressController {
    private final AddressService service;
    private final AddressWebMapper mapper;
    private final CustomerService customerService;
    @Autowired
    public AddressController(AddressService addressService, AddressWebMapper mapper, CustomerService customerService) {
        this.service = addressService;
        this.mapper = mapper;
        this.customerService = customerService;
    }

    @PostMapping
    public void create(@RequestBody AddressRequest request) {
        Integer customerId = request.customerId();
        customerService.checkCustomerId(customerId);
        log.info("Add new address registration {}", request);
        Customer customer = customerService.findById(customerId);
        service.save(request, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        service.deleteById(id);
        log.info("Address with ID {} was deleted successfully", id);
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return mapper.dtos(service.getAll());
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable(value = "id") Integer id) {
        Address address = service.findById(id);
        return mapper.dto(address);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(value = "id") Integer id, @RequestBody AddressRequest request) {
        service.updateById(id, request);
    }

}
