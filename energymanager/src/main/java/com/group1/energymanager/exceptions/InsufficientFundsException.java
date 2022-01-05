package com.group1.energymanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "not enough money on bank account")
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message){
        super(message);
    }
}
