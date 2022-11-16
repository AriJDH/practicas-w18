package com.example.Blog.exception;

public class EntradaBlogNotFoundException extends RuntimeException {

    public EntradaBlogNotFoundException() {
    }

    public EntradaBlogNotFoundException(String message) {
        super(message);
    }
}
