package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    
    public ResponseEntity<?> handleValidationExceptions
    (MethodArgumentNotValidException e) { 
        List<FieldError> fieldErrors = e
                .getBindingResult() 
                .getFieldErrors(); 

        List<ErrorDTO> collect = fieldErrors
                .stream()
                .map(fieldError ->
                        new ErrorDTO(HttpStatus.BAD_REQUEST.value() ,String
                                .format("%s",
                                        fieldError.getDefaultMessage())))
                .collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.BAD_REQUEST);
    }
}


