package com.ejercicios.blog.exception;

public class BlogEntryNotFoundException extends RuntimeException {
    public BlogEntryNotFoundException(String message) {
        super(message);
    }
}
