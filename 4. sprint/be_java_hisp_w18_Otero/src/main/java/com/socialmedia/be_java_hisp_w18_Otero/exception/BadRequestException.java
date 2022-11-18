package com.socialmedia.be_java_hisp_w18_Otero.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
