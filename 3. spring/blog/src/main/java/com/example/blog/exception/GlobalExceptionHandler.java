package com.example.blog.exception;

import com.example.blog.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictResourceException.class)
    public ResponseEntity<?> ConflictResourceException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), 409);
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }
}
