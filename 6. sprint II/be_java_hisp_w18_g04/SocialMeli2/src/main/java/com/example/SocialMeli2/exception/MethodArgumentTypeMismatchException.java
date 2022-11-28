package com.example.SocialMeli2.exception;

public class MethodArgumentTypeMismatchException extends RuntimeException{
    public MethodArgumentTypeMismatchException() {
    }

    public MethodArgumentTypeMismatchException(String message) {
        super(message);
    }
}
