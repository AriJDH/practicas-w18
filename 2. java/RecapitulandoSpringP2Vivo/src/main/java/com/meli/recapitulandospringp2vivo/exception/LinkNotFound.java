package com.meli.recapitulandospringp2vivo.exception;

public class LinkNotFound extends RuntimeException{
    public LinkNotFound() {
    }

    public LinkNotFound(String message) {
        super(message);
    }
}
