package com.example.joyeria.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
            super(message);
        }
}
