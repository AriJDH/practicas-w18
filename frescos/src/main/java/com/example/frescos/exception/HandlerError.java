package com.example.frescos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerError {

    @ExceptionHandler({UserNotFoundException.class, EntityNotFoundException.class, FullSectionException.class, IncorrectSectionException.class, BadRequestException.class})
    public ResponseEntity<String>  handleNotFound
            ( Exception exception ) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
