package com.example.tester.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TestCaseResponse {
    private HttpStatus status;
    private String message;
}
