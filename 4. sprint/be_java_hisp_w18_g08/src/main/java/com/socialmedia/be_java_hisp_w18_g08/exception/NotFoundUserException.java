package com.socialmedia.be_java_hisp_w18_g08.exception;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String msg){
        super(msg);
    }
}
