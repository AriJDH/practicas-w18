package com.link.linksproject.excepciones;

public class PasswordErrorException extends RuntimeException{
    public PasswordErrorException(String message) {
        super(message);
    }
}
