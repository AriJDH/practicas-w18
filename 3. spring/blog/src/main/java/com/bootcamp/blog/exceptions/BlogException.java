package com.bootcamp.blog.exceptions;

public class BlogException extends RuntimeException{
    public BlogException() {
    }

    public BlogException(String message) {
        super(message);
    }
}
