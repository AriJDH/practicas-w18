package com.link.exception;

import com.link.dto.ErrorExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTO> invalidException(InvalidException invalidException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTO(invalidException.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTO> noFoundException(NoFoundException noFoundException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTO(noFoundException.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND);
    }
}
