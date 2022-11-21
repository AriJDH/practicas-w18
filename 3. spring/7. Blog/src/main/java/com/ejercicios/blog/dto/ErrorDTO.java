package com.ejercicios.blog.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private Integer errorCode;
}
