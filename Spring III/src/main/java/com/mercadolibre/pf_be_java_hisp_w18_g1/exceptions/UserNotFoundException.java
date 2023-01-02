package com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("User y/o contraseña incorrecto");
    }
}
