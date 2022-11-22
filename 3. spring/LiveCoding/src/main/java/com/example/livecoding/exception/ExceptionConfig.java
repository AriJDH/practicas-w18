package com.example.livecoding.exception;

import com.example.livecoding.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturandoValidaciones(MethodArgumentNotValidException e){
        ErrorDto errorDto = new ErrorDto(e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.OK);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
