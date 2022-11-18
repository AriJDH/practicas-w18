package com.example.spring.excepciones.blog.exception;

public class EmptyException extends RuntimeException{
    public EmptyException(String message) {
        super(message);
    }
}
