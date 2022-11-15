package com.example.calculadoracalorias.exception;

public class ConflictResourceException extends RuntimeException{

    public ConflictResourceException() {
    }

    public ConflictResourceException(String message) {
        super(message);
    }
}
