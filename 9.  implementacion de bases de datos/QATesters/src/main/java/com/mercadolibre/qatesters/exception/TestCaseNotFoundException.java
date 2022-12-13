package com.mercadolibre.qatesters.exception;

public class TestCaseNotFoundException extends RuntimeException{
    public TestCaseNotFoundException(Long id) {
        super("Test Case con ID " + id + " no encontrado.");
    }
}
