package com.example.joyerialasperlas.exceptions;

/**
 * Exception to handle bad request
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
