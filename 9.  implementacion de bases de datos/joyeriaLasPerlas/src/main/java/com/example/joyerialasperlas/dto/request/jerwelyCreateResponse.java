package com.example.joyerialasperlas.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class jerwelyCreateResponse {
    private String message;
    private HttpStatus status;
}
