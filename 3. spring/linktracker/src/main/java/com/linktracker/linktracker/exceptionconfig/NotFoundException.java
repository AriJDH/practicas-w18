package com.linktracker.linktracker.exceptionconfig;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
