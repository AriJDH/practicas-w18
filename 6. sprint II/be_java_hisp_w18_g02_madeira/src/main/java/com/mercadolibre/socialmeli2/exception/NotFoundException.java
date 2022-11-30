package com.mercadolibre.socialmeli2.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Integer id){
        super("No se pudo encontrar al usuario " + id);
    }

    public NotFoundException(String message){
        super(message);
    }

}
