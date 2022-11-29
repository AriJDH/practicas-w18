package com.example.SocialMeli2.exception;

public class MissingServletRequestParameterException extends RuntimeException{

    public MissingServletRequestParameterException() {
    }

    public MissingServletRequestParameterException(String message) {
        super(message);
    }
}
