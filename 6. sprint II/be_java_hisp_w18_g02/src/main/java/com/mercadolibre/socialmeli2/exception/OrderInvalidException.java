package com.mercadolibre.socialmeli2.exception;

public class OrderInvalidException extends RuntimeException{
    public OrderInvalidException() {
        super("El tipo de ordenamiento no es válido.");
    }
}
