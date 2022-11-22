package com.mercadolibre.Redirect.exception;

import com.mercadolibre.Redirect.dto.response.LinkErrorExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler
    public ResponseEntity<LinkErrorExceptionDTO> errorException(ErrorException errorException){
        return new ResponseEntity<>(
                new LinkErrorExceptionDTO(errorException.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<LinkErrorExceptionDTO> notFoundException(Exception ex){
        LinkErrorExceptionDTO error = new LinkErrorExceptionDTO(ex.getMessage(), 404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
