package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountDto;
import com.eazybytes.accounts.entity.Accounts;

/**
 * Used for mapping between entities and dtos
 */
public class AccountsMapper {

    public static AccountDto mapToAccountsDto(Accounts accounts, AccountDto accountDto) {
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBranchAddress(accounts.getBranchAddress());
        return accountDto;
    }

    public static Accounts mapToAccountsEntity(AccountDto accountDto, Accounts accounts) {
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        return accounts;
    }
}
