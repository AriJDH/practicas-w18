package com.meli.springmanejoexcepcionesp1vivo.exception;

import com.meli.springmanejoexcepcionesp1vivo.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogExistException.class)
    public ResponseEntity<ErrorDto> BlogExistException(Exception e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlogNoExistException.class)
    public ResponseEntity<?> blogNoExistException(Exception e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
