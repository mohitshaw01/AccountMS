package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountConstants;
import com.eazybytes.accounts.dto.AccountDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exceptions.CustomerAlreadyExistException;
import com.eazybytes.accounts.exceptions.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    /**
     * creating customer and creating account of that customer
     *
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        // There should be no customer with the same mobileNumber
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exist with mobile number: " + customerDto.getMobileNumber());
        }
        Customer customer = CustomerMapper.mapToCustomerEntity(customerDto, new Customer());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy(customerDto.getName());
        Customer savedCustomer = customerRepository.save(customer);
        Accounts accounts = createNewAccount(savedCustomer);
        accountRepository.save(accounts);
    }

    /**
     * fetch accountDetails of the customer
     *
     * @param mobileNumber
     * @return customerDto
     */
    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(mobileNumber);
        if (!optionalCustomer.isPresent()) {
            throw new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber);
        }
        Customer customer = optionalCustomer.get();
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", String.valueOf(customer.getCustomerId())));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        AccountDto accountDto = AccountsMapper.mapToAccountsDto(accounts, new AccountDto());
        customerDto.setAccountDto(accountDto);
        return customerDto;
    }

    /**
     * creating new account for existing customer
     *
     * @param customer
     * @return accounts
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long randomAccountNumberGeneration = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        accounts.setAccountNumber(randomAccountNumberGeneration);
        accounts.setAccountType(AccountConstants.SAVINGS);
        accounts.setBranchAddress(AccountConstants.ADDRESS);
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy(customer.getName());
        return accounts;
    }
}
