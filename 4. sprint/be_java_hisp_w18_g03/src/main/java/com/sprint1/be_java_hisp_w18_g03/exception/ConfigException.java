package com.sprint1.be_java_hisp_w18_g03.exception;

import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundUserException(NoFoundException noFoundException) {
        return new ResponseEntity<>(new ResponseDTO(noFoundException.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CreationException.class)
    public ResponseEntity<?> creationException(CreationException creationException) {
        return new ResponseEntity<>(new ResponseDTO(creationException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}
