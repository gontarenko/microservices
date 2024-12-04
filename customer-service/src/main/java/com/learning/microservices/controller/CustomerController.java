package com.learning.microservices.controller;

import com.learning.microservices.controller.dto.CustomerRequest;
import com.learning.microservices.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(
        CustomerService customerService
) {

    @PostMapping
    public void register(@RequestBody CustomerRequest request) {
        log.info("new customer registration {}", request);
        customerService.save(request);
    }
}
