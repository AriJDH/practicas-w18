package com.example.joyerialasperlas.exceptions;

/**
 * Exception to handle bad request
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
