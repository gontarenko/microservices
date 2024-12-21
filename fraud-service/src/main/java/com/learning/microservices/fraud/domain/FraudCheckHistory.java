package com.learning.microservices.fraud.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "fraud_check_history_id_seq", sequenceName = "fraud_check_history_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_check_history_id_seq")
    private Integer id;

    private Integer customerId;

    private Boolean fraudster;

    private LocalDateTime createdAt;

    public FraudCheckHistory() {
    }

    public FraudCheckHistory(Integer id, Integer customerId, Boolean fraudster, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.fraudster = fraudster;
        this.createdAt = createdAt;
    }
}
