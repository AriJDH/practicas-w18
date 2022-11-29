package com.meli.be_java_hisp_w18_g01.exceptions;

public class UserNotFollowedException extends RuntimeException{
    public UserNotFollowedException(String message){
        super(message);
    }
}
