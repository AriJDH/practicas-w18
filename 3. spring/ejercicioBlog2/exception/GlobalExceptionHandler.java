package com.mercadolibre.blog.exception;

import com.mercadolibre.blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NotFoundException e){
        return this.generalExceptionHandler(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> alreadyExistsExceptionHandler(AlreadyExistsException e){
        return this.generalExceptionHandler(HttpStatus.BAD_REQUEST, e);
    }

    private ResponseEntity<ErrorDTO> generalExceptionHandler(HttpStatus status, Exception e){
        ErrorDTO err = new ErrorDTO(e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }

}
