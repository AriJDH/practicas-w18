package com.demoblog.demoblog.exception.handler;

public class IdNotExists extends RuntimeException{
    public IdNotExists(String message) {
        super(message);
    }
}
