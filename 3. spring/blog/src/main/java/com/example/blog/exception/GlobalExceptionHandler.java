package com.example.blog.exception;

import com.example.blog.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> NotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(404,e.getMessage(), LocalDate.now());
        return new ResponseEntity<>(errorDTO,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorDTO> AlreadyExist(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(409,e.getMessage(),LocalDate.now());
        return new ResponseEntity<>(errorDTO,HttpStatus.CONFLICT);
    }


}
