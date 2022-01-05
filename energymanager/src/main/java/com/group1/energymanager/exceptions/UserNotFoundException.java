package com.group1.energymanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such User")
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
