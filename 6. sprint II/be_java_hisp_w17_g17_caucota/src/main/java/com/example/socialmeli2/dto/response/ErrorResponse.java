package com.example.socialmeli2.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer statusCode;

}
