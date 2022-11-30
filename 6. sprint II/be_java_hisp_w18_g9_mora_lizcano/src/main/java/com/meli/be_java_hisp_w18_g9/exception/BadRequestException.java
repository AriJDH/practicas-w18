package com.meli.be_java_hisp_w18_g9.exception;

/**
 * Exception to handle bad request
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }

}
