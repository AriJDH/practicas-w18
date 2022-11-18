package com.socialmedia.be_java_hisp_w18_g08_escandon.exception;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String msg) {
        super(msg);
    }
}
