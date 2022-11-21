package com.ejercicios.blog.exception;


public class BlogEntryRepeatedException extends RuntimeException {
    public BlogEntryRepeatedException(String message) {
        super(message);
    }


}
