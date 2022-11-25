package com.meli.starwars.exception;

public class NoFoundException extends RuntimeException {

    public NoFoundException(String message) {
        super(message);
    }
}
