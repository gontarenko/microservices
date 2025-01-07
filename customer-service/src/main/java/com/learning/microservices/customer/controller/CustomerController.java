package com.learning.microservices.customer.controller;

import com.learning.microservices.customer.controller.dto.CustomerDto;
import com.learning.microservices.customer.controller.dto.CustomerRequest;
import com.learning.microservices.customer.domain.Customer;
import com.learning.microservices.customer.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService customerService;

    @PostMapping
    public void register(@RequestBody CustomerRequest request) {
        log.info("new customer registration {}", request);
        customerService.save(request);
    }

    @GetMapping("all")
    public List<CustomerDto> getAll() {
        //Получить всех пользователей из сервиса
        //Смапить их в дто и отдать
        List<Customer> customers = customerService.getAll();
        List<CustomerDto> response = new ArrayList<>(customers.size());
        for (Customer customer : customers) {
            CustomerDto dto = new CustomerDto();
            dto.setId(customer.getId());
            dto.setEmail(customer.getEmail());
            response.add(dto);
        }
        return response;
    }

}
