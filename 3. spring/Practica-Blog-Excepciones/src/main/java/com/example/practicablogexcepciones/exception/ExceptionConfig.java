package com.example.practicablogexcepciones.exception;

import com.example.practicablogexcepciones.dto.response.ErrorDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException exception){
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), 404);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
