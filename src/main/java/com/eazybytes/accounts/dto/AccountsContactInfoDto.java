package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "account")
public record AccountsContactInfoDto(
        String message,
        List<Map<String, String>> contact, // Corrected to List<Map<String, String>>
        Address address, // Corrected to use an Address DTO instead of String
        List<Map<String, String>> onCallSupport // Corrected to List<Map<String, String>>
) {

    public record Address(String street, String city, String state, String zip) {
    }
}