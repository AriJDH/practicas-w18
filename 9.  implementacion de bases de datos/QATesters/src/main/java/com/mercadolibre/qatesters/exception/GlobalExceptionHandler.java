package com.mercadolibre.qatesters.exception;

import com.mercadolibre.qatesters.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TestCaseNotFoundException.class)
    public ResponseEntity<ResponseDTO> testCaseNotFoundExceptionHandler(TestCaseNotFoundException e){
        return new ResponseEntity<>(new ResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
