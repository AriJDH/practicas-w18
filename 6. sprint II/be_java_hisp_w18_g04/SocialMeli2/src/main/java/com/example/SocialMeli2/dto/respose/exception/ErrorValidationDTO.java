package com.example.SocialMeli2.dto.respose.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ErrorValidationDTO {
    private HttpStatus status;
    private String name;
    private String message;
    private HashMap<String, List<String>> errorFields;
}
