package com.eazybytes.accounts.dto;

import lombok.Data;

@Data
public class AccountDto {
    private long accountNumber;
    private String accountType;
    private String branchAddress;
}
