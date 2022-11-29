package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDto {

    private String name;
    private String message;
    private List<String> messages;

    public ErrorDto(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ErrorDto(String name, List<String> messages) {
        this.name = name;
        this.messages = messages;
    }
}
