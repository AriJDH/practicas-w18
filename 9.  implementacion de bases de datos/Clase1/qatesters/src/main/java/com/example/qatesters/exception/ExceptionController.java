package com.example.qatesters.exception;

import com.example.qatesters.dto.response.GenericsDTORes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericsDTORes> genericException(Exception ex){
        GenericsDTORes error = new GenericsDTORes(404 ,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
