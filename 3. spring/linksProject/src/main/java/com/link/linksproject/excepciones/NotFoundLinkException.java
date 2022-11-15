package com.link.linksproject.excepciones;

public class NotFoundLinkException extends RuntimeException{
    public NotFoundLinkException(String message) {
        super(message);
    }
}
