package com.example.socialmeli.exception;

import com.example.socialmeli.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> MethodArgumentTypeMismatchException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse("Se introdujo un tipo de parámetro incorrecto al requerido", 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
