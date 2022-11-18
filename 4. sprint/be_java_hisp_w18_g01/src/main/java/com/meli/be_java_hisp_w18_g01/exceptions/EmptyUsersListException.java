package com.meli.be_java_hisp_w18_g01.exceptions;

public class EmptyUsersListException extends RuntimeException{
    public EmptyUsersListException(String message){
        super(message);
    }
}
