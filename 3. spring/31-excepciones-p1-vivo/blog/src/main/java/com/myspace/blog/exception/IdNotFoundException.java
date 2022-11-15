package com.myspace.blog.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }
}
