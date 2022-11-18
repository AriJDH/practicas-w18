package com.example.linktracker.exceptions;

import com.example.linktracker.dtos.ResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFound(Exception e){
        return new ResponseEntity<>(new ResponseDTO(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidUrlException.class, InvalidatedLinkException.class, IncorrectPasswordException.class})
    public ResponseEntity<ResponseDTO> handleBadRequest(Exception e){
        return ResponseEntity.badRequest().body(new ResponseDTO(e.getMessage(), 400));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseDTO> handleServersideError(Exception e){
        return ResponseEntity.internalServerError()
                .body(new ResponseDTO("Ha ocurrido un error en el servidor, consulte con un administrador.", 500));
    }
}
