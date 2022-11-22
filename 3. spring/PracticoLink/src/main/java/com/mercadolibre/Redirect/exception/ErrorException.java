package com.mercadolibre.Redirect.exception;

public class ErrorException extends RuntimeException{
    public ErrorException() {
    }

    public ErrorException(String message) {
        super(message);
    }
}
