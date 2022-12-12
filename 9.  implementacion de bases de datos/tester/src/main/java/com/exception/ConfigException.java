package com.exception;


import com.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundException(NoFoundException noFoundException) {
        return new ResponseEntity<>(new ResponseDTO(noFoundException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}
