package com.mercadolibre.socialmeli.exception;


import com.mercadolibre.socialmeli.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException e){
        ErrorDto eDto = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> IllegalArgument(IllegalArgumentException e){
        ErrorDto eDto = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }
}
