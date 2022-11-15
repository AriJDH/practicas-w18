package com.meli.springmanejoexcepcionesp1vivo.exception;

public class BlogExistException extends RuntimeException {
    public BlogExistException() {
    }

    public BlogExistException(String message) {
        super(message);
    }
}
