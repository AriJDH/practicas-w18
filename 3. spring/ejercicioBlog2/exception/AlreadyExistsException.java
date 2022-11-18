package com.mercadolibre.blog.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
