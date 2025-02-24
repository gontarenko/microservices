package com.learning.microservices.customer.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, String email, List<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = addresses;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
