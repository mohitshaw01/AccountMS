package com.eazybytes.accounts.Repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
