package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountDto {
    @NotEmpty(message = "Account Number cannot be empty")
    private long accountNumber;
    @NotEmpty(message = "Account Type cannot be empty")
    private String accountType;
    @NotNull(message = "Branch Address cannot be empty")
    private String branchAddress;
}
