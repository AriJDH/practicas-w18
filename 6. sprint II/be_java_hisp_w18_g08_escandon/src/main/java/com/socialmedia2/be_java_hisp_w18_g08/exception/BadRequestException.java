package com.socialmedia2.be_java_hisp_w18_g08.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
