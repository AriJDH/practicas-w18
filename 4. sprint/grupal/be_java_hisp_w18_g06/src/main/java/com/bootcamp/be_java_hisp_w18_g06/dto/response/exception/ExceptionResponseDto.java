package com.bootcamp.be_java_hisp_w18_g06.dto.response.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    private String message;
    private int statusCode;
}
