package com.mercadolibre.socialmeli.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg){
        super(msg);
    }

}
