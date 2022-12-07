package com.jpa.joyeria.exception;

import com.jpa.joyeria.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionController {
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericResponseDTO> userGenericException(Exception ex){
        GenericResponseDTO error = new GenericResponseDTO(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
