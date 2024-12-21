package com.learning.microservices.fraud.service;

public interface FraudCheckHistoryService {
    boolean isFraudster(Integer customerId);
}
