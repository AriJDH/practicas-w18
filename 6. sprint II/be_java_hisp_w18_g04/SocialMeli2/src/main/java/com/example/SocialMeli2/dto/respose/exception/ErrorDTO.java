package com.example.SocialMeli2.dto.respose.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDTO {
    private Integer status;
    private String message;
}
