package com.eazybytes.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException {
    /**
     * constructor for exception
     * whatever message goes in this will go to the super class exception
     *
     * @param message
     */
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
