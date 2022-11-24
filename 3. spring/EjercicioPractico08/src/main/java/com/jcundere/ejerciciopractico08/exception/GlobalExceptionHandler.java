package com.jcundere.ejerciciopractico08.exception;

import com.jcundere.ejerciciopractico08.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> NotFoundException(Exception e) {

        ErrorResponse response = new ErrorResponse(e.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RepeatedException.class)
    public ResponseEntity<ErrorResponse> RepeatedException(Exception e) {

        ErrorResponse response = new ErrorResponse(e.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
