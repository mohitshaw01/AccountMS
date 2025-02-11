package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts,Long>{

    Optional<Accounts> findByCustomerId(long customerId);

    Optional<Accounts> findByAccountNumber(long accountNumber);
}