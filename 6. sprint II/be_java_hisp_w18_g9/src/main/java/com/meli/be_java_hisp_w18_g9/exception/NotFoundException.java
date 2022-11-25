package com.meli.be_java_hisp_w18_g9.exception;

/**
 * Exception to handle not found resources
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
