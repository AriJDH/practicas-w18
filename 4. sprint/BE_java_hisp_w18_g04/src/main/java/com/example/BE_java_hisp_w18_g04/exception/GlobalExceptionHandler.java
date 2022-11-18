package com.example.BE_java_hisp_w18_g04.exception;

import com.example.BE_java_hisp_w18_g04.dto.respose.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> BadRequestException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(400,e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
