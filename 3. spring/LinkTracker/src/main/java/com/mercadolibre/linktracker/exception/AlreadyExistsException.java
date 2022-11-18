package com.mercadolibre.linktracker.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
