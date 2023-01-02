package com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
