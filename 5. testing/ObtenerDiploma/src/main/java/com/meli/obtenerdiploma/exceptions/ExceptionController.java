package com.meli.obtenerdiploma.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> handleValitationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<String> handleValitationException(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
