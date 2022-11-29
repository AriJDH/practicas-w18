package com.example.SocialMeli2.exception;

public class TypeMismatchException extends RuntimeException{
    public TypeMismatchException() {
    }

    public TypeMismatchException(String message) {
        super(message);
    }
}
