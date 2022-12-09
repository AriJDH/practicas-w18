package com.example.joyerialasperlas.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class JerwelyDtoResponse {
    private String message;
    private HttpStatus status;
}
