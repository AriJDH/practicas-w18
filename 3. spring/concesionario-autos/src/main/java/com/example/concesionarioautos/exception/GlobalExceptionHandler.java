package com.example.concesionarioautos.exception;

import com.example.concesionarioautos.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
