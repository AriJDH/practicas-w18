package com.example.frescos.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("User y/o contraseña incorrecto");
    }
}
