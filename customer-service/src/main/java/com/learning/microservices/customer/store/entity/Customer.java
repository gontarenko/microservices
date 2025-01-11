package com.learning.microservices.customer.store.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
