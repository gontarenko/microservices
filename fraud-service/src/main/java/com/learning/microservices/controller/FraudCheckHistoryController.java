package com.learning.microservices.controller;


import com.learning.microservices.clients.fraud.FraudServiceClient;
import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.service.FraudCheckHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(FraudServiceClient.PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FraudCheckHistoryController implements FraudServiceClient {
    FraudCheckHistoryService service;

    @GetMapping(params = "customerId")
    public FraudCheckResponse isFraudster(@RequestParam(name = "customerId") Integer customerId) {
        log.info("fraud check request for customer id = {}", customerId);
        return new FraudCheckResponse(service.isFraudster(customerId));
    }
}
