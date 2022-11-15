package com.dh.blog.exception;

import com.dh.blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfiguration {

    @ExceptionHandler(BlogEntryRepeatedException.class)
    public ResponseEntity<?> blogEntryRepeatedException(BlogEntryRepeatedException e){
        ErrorDTO err = new ErrorDTO(e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BlogEntryNotFoundException.class)
    public ResponseEntity<?> blogEntryNotFoundException(BlogEntryNotFoundException e){
        ErrorDTO err = new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> blogEntryIllegalArgumentException(IllegalArgumentException e){
        ErrorDTO err = new ErrorDTO(e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
    }

}
