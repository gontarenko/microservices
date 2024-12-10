package com.learning.microservices.controller;


import com.learning.microservices.clients.fraud.dto.FraudCheckResponse;
import com.learning.microservices.clients.notification.NotificationClient;
import com.learning.microservices.clients.notification.dto.SendNotificationRequest;
import com.learning.microservices.service.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(NotificationClient.PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController implements NotificationClient {
    NotificationService service;

    @PostMapping
    public void send(@RequestBody SendNotificationRequest request) {
        log.info("send notification request for customer id = {}, email = {}, message = {}",
                request.toCustomerId(), request.toCustomerEmail(), request.message());
        service.send(request);
    }
}
