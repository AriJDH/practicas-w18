package com.uhu.multicapa.exception;

import com.uhu.multicapa.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noEncontrado(NotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
