package com.myspace.blog.exception;

public class DuplicateIdException extends RuntimeException {
    public DuplicateIdException(String message) {
        super(message);
    }
}
