package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.AccountDto;
import com.eazybytes.accounts.dto.CustomerDto;

/**
 *
 */
public interface IAccountService {
    /**\
     *  creating user Account
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**\
     *  fetching user Account
     * @param mobileNumber
     * @return
     */
    CustomerDto fetchAccountDetails(String mobileNumber);

    Boolean updateAccount(CustomerDto customerDto);

    Boolean deleteAccount(String mobileNumber);
}
