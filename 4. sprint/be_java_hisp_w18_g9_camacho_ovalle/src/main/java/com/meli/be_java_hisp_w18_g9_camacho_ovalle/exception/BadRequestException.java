package com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception;

/**
 * Exception to handle bad request
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }

}
