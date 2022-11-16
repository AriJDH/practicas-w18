package com.sprint1.be_java_hisp_w18_g03.exception;

public class NoFoundUserException extends RuntimeException {

    public NoFoundUserException(String message) {
        super(message);
    }
}
