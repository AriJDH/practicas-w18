package com.meli.be_java_hisp_w18_g01.exceptions;

public class EmptyUsersRepositoryException extends RuntimeException{
    public EmptyUsersRepositoryException(String message){
        super(message);
    }
}
