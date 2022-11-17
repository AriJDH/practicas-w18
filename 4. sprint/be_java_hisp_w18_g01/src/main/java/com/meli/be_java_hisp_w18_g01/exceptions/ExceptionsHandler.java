package com.meli.be_java_hisp_w18_g01.exceptions;

import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NotSellerException.class, BadRequestException.class})
    public ResponseEntity<?> handleBadRequest(Exception e){
        //return ResponseEntity.badRequest().body(e.getMessage());//TODO: enviarlo en un dto
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> handleNotFound(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({UserAlreadyFollowedException.class})
    public ResponseEntity<?> handleConflict(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.CONFLICT.value(),
                        e.getMessage()),
                HttpStatus.CONFLICT
        );
    }

}
