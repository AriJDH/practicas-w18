package com.example.empresadeseguros.exception;

import org.aspectj.weaver.ast.Not;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
