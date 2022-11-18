package com.mercadolibre.linktracker.exception;

import com.mercadolibre.linktracker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(status)
                .body(new ErrorDTO(e.getMessage(), status.value(), LocalDateTime.now()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> alreadyExistsExceptionHandler(AlreadyExistsException e){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity
                .status(status)
                .body(new ErrorDTO(e.getMessage(), status.value(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidPassException.class)
    public ResponseEntity<ErrorDTO> invalidPassExceptionHandler(InvalidPassException e){
        HttpStatus status = HttpStatus.FORBIDDEN;
        return ResponseEntity
                .status(status)
                .body(new ErrorDTO(e.getMessage(), status.value(), LocalDateTime.now()));
    }

}
