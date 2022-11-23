package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomException> handleValidationExceptions(MethodArgumentNotValidException ex){
        CustomException customException = new CustomException(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomException> handleValidationExceptions(HttpMessageNotReadableException ex){
        CustomException customException = new CustomException(ex.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

}
