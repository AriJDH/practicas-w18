package com.example.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorExceptionDTO {

    private String message;

    private int status;
}
