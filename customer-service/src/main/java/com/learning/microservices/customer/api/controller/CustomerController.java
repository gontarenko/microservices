package com.learning.microservices.customer.api.controller;

import com.learning.microservices.customer.api.dto.AddressDto;
import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.api.dto.CustomerDto;
import com.learning.microservices.customer.api.exception.CustomerNotFoundException;
import com.learning.microservices.customer.api.mapper.AddressWebMapper;
import com.learning.microservices.customer.api.mapper.CustomerWebMapper;
import com.learning.microservices.customer.domain.entity.Customer;
import com.learning.microservices.customer.service.CustomerService;
import com.learning.microservices.customer.service.mapper.AddressMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService service;
    CustomerWebMapper mapper;
    AddressWebMapper addressMapper;

    @PostMapping
    public void register(@RequestBody CustomerRequest request) {
        log.info("new customer registration {}", request);
        service.save(request);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<List<AddressDto>> getAddresses(@PathVariable(value = "id") Integer id) {
        service.checkCustomerId(id);
        log.info("Addresses of customer_id {}:", id);
        Customer customer = service.findById(id);
        List<AddressDto> addresses = addressMapper.dtos(customer.getAddresses());
        return ResponseEntity.ok(addresses);
    }

    @GetMapping
    public List<CustomerDto> getAll() {
        return mapper.dtos(service.getAll());
    }
}
