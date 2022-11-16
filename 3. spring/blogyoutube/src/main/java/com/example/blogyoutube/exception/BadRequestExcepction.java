package com.example.blogyoutube.exception;

public class BadRequestExcepction extends RuntimeException{

    public BadRequestExcepction() {
    }

    public BadRequestExcepction(String message) {
        super(message);
    }

}
