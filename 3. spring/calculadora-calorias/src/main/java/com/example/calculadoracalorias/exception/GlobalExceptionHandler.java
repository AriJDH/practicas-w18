package com.example.calculadoracalorias.exception;

import com.example.calculadoracalorias.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictResourceException.class)
    public ResponseEntity<?> ConflictResourceException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(e.getMessage(), 409);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.CONFLICT);
    }
}
