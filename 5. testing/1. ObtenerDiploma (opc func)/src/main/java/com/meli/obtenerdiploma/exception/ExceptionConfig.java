package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice//(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        List<String> messages = ex.getFieldErrors().stream().map(s->s.getDefaultMessage()).collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponseDTO(messages, 400, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorResponseDTO> HttpMediaTypeNotAcceptableExceptionHandler(HttpMediaTypeNotAcceptableException ex){
        List<String> messages = Arrays.asList(ex.getMessage());

        return new ResponseEntity<>(new ErrorResponseDTO(messages, 400, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }




}
