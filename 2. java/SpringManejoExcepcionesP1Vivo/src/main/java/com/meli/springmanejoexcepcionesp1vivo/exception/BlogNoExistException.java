package com.meli.springmanejoexcepcionesp1vivo.exception;

public class BlogNoExistException extends RuntimeException {
    public BlogNoExistException() {
    }

    public BlogNoExistException(String message) {
        super(message);
    }
}
