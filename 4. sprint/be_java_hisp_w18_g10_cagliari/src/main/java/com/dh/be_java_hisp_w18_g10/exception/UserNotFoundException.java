package com.dh.be_java_hisp_w18_g10.exception;

public class UserNotFoundException extends RuntimeException{
    private final int userId;
    public UserNotFoundException(int userId) {
        super("User not found.");
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
