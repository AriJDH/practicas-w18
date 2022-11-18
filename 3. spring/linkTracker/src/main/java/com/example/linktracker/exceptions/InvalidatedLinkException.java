package com.example.linktracker.exceptions;

public class InvalidatedLinkException extends RuntimeException{
    public InvalidatedLinkException(String message){
        super(message);
    }
}
