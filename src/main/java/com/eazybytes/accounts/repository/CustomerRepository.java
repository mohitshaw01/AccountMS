package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * The optional is used to handle the case where the customer is not found by mobileNumber
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
