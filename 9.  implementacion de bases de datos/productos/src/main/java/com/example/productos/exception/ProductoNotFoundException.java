package com.example.productos.exception;

public class ProductoNotFoundException extends RuntimeException{

    public ProductoNotFoundException() {
    }

    public ProductoNotFoundException(String message) {
        super(message);
    }
}
