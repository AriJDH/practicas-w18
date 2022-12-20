package com.example.joyeria.controller;

import com.example.joyeria.dto.response.ResponseDTO;
import com.example.joyeria.exception.BadRequestException;
import com.example.joyeria.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> obtenerObjetoVacio(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> enviarRequerimientosMalos(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
