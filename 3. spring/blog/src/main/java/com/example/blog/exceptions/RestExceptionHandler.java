package com.example.blog.exceptions;

import com.example.blog.dtos.ResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ResponseDTO> handleNotFound(Exception e){
        return new ResponseEntity<>(new ResponseDTO(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityAlreadyExistsException.class})
    public ResponseEntity<ResponseDTO> handleConflict(Exception e){
        return new ResponseEntity<>(new ResponseDTO(e.getMessage(), 409), HttpStatus.CONFLICT);
    }
}
