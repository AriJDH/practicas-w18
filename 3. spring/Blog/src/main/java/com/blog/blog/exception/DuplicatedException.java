package com.blog.blog.exception;

public class DuplicatedException extends RuntimeException{
    public DuplicatedException(){}

    public DuplicatedException(String message){
        super(message);
    }
}
