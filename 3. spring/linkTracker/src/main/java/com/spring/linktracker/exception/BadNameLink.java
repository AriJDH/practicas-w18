package com.spring.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "El link no es correcto")
public class BadNameLink extends RuntimeException{

    public BadNameLink(String message){
        super(message);
    }
}
