package com.meli.be_java_hisp_w18_g01.exceptions;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String message){
        super(message);
    }
}
