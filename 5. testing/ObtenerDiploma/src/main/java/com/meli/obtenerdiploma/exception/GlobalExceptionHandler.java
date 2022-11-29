package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> messages = methodArgumentNotValidException.getFieldErrors().stream().map(m -> m.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorDto(400, messages), HttpStatus.BAD_REQUEST);
    }
}
