package com.myspace.blog.exception;

import com.myspace.blog.dto.response.IdErrorDTORes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<?> DuplicateIdException(Exception e) {
        IdErrorDTORes idErrorDTORes = new IdErrorDTORes(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(idErrorDTORes, idErrorDTORes.getStatus());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> IdNotFoundException(Exception e) {
        IdErrorDTORes idErrorDTORes = new IdErrorDTORes(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(idErrorDTORes, idErrorDTORes.getStatus());
    }
}
