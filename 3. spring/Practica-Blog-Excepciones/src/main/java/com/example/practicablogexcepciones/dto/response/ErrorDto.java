package com.example.practicablogexcepciones.dto.response;

public class ErrorDto {
    private String message;
    private int status;

    public ErrorDto(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
