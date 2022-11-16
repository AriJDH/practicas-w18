package com.meli.be_java_hisp_w18_g01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NotSellerException.class})
    public ResponseEntity<?> handleBadRequest(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());//TODO: enviarlo en un dto
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> handleNotFound(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserAlreadyFollowedException.class})
    public ResponseEntity<?> handleConflict(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
