package com.learning.microservices.customer.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(Integer id, Customer customer, String street, String city, String state, String postalCode,
                   String country) {
        this.id = id;
        this.customer = customer;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address() {

    }

    public Integer getCustomerId() {
        return this.customer.getId();
    }
}
