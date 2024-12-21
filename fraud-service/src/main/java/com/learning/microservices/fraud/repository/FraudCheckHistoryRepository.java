package com.learning.microservices.fraud.repository;

import com.learning.microservices.fraud.domain.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
