package com.learning.microservices.customer.store.repository;

import com.learning.microservices.customer.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
