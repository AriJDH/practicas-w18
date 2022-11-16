package com.example.Blog.exception;

import com.example.Blog.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntradaBlogNotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntradaBlogFoundException.class)
    public ResponseEntity<?> BadRequestException(Exception e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.FOUND);
    }

}
