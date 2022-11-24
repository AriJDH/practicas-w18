package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDto> badRequestException(BadRequestException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponseDto(e.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> emptyException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)  //TODO Chequear status
                .body(new ExceptionResponseDto(e.getBindingResult().getFieldError().getDefaultMessage()));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponseDto> notFoundException(HttpMessageNotReadableException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST) //TODO Chequear status
                .body(new ExceptionResponseDto(e.getMessage()));
    }
}
