package com.meli.obtenerdiploma.exeption;

import com.meli.obtenerdiploma.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturarValidaciones(MethodArgumentNotValidException e){
        List<String> messages = e.getFieldErrors().stream().map(s->s.getDefaultMessage()).collect(Collectors.toList());
        ErrorDto error = new ErrorDto(e.getClass().getSimpleName(), messages);
        //ErrorDto error = new ErrorDto(e.getClass().getSimpleName(), e.getBindingResult().getFieldError().getDefaultMessage());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturarValidaciones(HttpMessageNotReadableException e){
        ErrorDto error = new ErrorDto(e.getClass().getSimpleName(), e.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
