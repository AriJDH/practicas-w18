package com.jcundere.ejerciciopractico09.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String messege) {
        super(messege);
    }
}
