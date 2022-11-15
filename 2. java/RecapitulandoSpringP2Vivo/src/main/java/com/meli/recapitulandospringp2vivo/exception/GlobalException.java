package com.meli.recapitulandospringp2vivo.exception;

import com.meli.recapitulandospringp2vivo.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalException {
    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<ErrorDto> linkNotFound(Exception e){
        return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
