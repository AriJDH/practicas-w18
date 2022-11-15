package com.dh.blog.exception;


public class BlogEntryRepeatedException extends RuntimeException {
    public BlogEntryRepeatedException(String message) {
        super(message);
    }


}
