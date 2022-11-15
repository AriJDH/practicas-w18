package com.blog.blog.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }
}
