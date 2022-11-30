package com.meli.obtenerdiploma.exceptionHandler;


import com.meli.obtenerdiploma.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionDto> catchingValidationException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ExceptionDto> catchingValidationException(HttpMessageNotReadableException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }
}
