package com.dh.linktracker.exception;

import com.dh.linktracker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotValidateLinkException.class)
    public ResponseEntity<?> notValidateLinkException(NotValidateLinkException e){
        ErrorDTO err = new ErrorDTO(HttpStatus.CONFLICT.value() ,e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }


}
