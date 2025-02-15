package com.learning.microservices.fraud.service;

import com.learning.microservices.fraud.domain.FraudCheckHistory;
import com.learning.microservices.fraud.repository.FraudCheckHistoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {
    FraudCheckHistoryRepository repository;

    public boolean isFraudster(Integer customerId) {
        boolean fraudster = false;
        FraudCheckHistory fraudCheck = FraudCheckHistory.builder()
                .customerId(customerId)
                .fraudster(fraudster)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(fraudCheck);
        return fraudster;
    }
}
