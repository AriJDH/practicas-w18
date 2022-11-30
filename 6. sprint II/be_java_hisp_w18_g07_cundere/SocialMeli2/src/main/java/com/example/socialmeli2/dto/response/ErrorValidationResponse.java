package com.example.socialmeli2.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorValidationResponse {

    String field;
    Object rejectedValue;
    String message;

}
