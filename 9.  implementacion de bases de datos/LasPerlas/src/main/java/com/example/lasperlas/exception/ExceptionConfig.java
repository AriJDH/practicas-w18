package com.example.lasperlas.exception;

import com.example.lasperlas.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundUserException(Exception e){
        ExceptionDto eDTO = new ExceptionDto(List.of(e.getMessage()), 404);
        return new ResponseEntity<>(eDTO, HttpStatus.NOT_FOUND);
    }
}
