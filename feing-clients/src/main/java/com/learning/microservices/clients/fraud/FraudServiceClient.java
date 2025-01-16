package com.learning.microservices.clients.fraud;

import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "fraud-service", path = FraudServiceClient.PATH, primary = false)
public interface FraudServiceClient {
    String PATH = "api/v1/fraud-check";

    @GetMapping(params = "customerId")
    FraudCheckResponse isFraudster(@RequestParam(name = "customerId") Integer customerId);
}
