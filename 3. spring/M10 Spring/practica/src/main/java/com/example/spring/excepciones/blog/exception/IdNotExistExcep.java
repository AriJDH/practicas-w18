package com.example.spring.excepciones.blog.exception;


public class IdNotExistExcep extends RuntimeException{
    public IdNotExistExcep(String message) {
        super(message);
    }
}
