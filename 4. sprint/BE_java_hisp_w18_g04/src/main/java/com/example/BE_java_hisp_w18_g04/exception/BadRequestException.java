package com.example.BE_java_hisp_w18_g04.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    } //Para poder personalizar el mensaje a la hora de dar la excepcion, usamos este constructor
}
