package com.example.frescos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerError {

    @ExceptionHandler({ FullSectionException.class, IncorrectSectionException.class, BadRequestException.class, InsuficientStockException.class})
    public ResponseEntity<String> handleBadRequest
            ( Exception exception ) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserNotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<String> handleNotFound(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<String> handleNotForbidden(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
