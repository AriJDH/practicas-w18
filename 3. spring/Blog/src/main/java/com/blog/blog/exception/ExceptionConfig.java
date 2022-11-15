package com.blog.blog.exception;

import com.blog.blog.controller.BlogController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig  {

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<?> DuplicatedException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
}
