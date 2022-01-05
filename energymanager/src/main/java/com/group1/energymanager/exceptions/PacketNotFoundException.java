package com.group1.energymanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "packet not found")
public class PacketNotFoundException extends Exception{
        public PacketNotFoundException(String message){
            super(message);
        }
    }

