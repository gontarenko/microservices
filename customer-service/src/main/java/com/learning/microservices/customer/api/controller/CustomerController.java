package com.learning.microservices.customer.api.controller;

import com.learning.microservices.customer.api.dto.CustomerRequest;
import com.learning.microservices.customer.api.dto.CustomerDto;
import com.learning.microservices.customer.api.mapper.CustomerWebMapper;
import com.learning.microservices.customer.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService customerService;
    CustomerWebMapper mapper;

    @PostMapping
    public void register(@RequestBody CustomerRequest request) {
        log.info("new customer registration {}", request);
        customerService.save(request);
    }

    @GetMapping
    public List<CustomerDto> getAll() {
        return mapper.dtos(customerService.getAll());
    }
}
