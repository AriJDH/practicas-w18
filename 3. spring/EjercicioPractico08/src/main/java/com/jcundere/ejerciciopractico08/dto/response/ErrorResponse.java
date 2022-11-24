package com.jcundere.ejerciciopractico08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String messege;
    private Integer statusCode;

}
