package com.mercadolibre.socialmeli2.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg){
        super(msg);
    }

}
