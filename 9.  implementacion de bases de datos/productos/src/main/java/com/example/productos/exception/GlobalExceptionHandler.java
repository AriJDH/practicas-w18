package com.example.productos.exception;

import com.example.productos.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserNotFoundException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(404, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
