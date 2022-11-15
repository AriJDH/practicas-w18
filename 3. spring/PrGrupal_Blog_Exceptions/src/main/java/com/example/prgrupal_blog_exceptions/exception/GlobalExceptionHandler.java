package com.example.prgrupal_blog_exceptions.exception;

import com.example.multicapavivo.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException e){
        ErrorDto eDto = new ErrorDto(e.getMessage(), 404);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(404));
    }

    @ExceptionHandler(AlreadyExistsExcepction.class)
    public ResponseEntity<?> yaExiste(AlreadyExistsExcepction e){
        ErrorDto eDto = new ErrorDto(e.getMessage(), 409);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(409));
    }
}
