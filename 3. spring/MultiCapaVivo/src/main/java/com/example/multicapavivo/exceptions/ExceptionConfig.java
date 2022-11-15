package com.example.multicapavivo.exceptions;

import com.example.multicapavivo.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException e){
        //return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        ErrorDto eDto = new ErrorDto(e.getMessage(), 404);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(404));
    }
}
