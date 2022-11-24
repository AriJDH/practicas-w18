package com.survive.livecoding.exception;

import com.survive.livecoding.dto.response.ErrorDTO;
import com.survive.livecoding.dto.response.ErrorDtoRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> captureValidation(MethodArgumentNotValidException e) {
        ErrorDtoRes errorDtoRes = new ErrorDtoRes(e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDtoRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> captureValidation(HttpMessageNotReadableException e) {
        ErrorDtoRes errorDtoRes = new ErrorDtoRes(e.getMessage());
        return new ResponseEntity<>(errorDtoRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
