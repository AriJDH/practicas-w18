package com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions;


public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
