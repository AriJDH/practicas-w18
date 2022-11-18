package com.dh.be_java_hisp_w18_g10.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found.");
    }
}
