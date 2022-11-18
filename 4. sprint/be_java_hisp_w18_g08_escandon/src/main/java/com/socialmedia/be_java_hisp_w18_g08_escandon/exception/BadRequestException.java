package com.socialmedia.be_java_hisp_w18_g08_escandon.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
