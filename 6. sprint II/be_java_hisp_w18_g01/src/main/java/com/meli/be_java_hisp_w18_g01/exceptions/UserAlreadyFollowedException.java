package com.meli.be_java_hisp_w18_g01.exceptions;

public class UserAlreadyFollowedException extends RuntimeException{
    public UserAlreadyFollowedException(String message){
        super(message);
    }
}
