package com.sprint1.be_java_hisp_w18_g03_serna.exception;

import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundException(NoFoundException noFoundException) {
        return new ResponseEntity<>(new ResponseDTO(noFoundException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreationException.class)
    public ResponseEntity<?> creationException(CreationException creationException) {
        return new ResponseEntity<>(new ResponseDTO(creationException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParamException.class)
    public ResponseEntity<?> paramException(ParamException paramException) {
        return new ResponseEntity<>(new ResponseDTO(paramException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<?> EmptyException(EmptyException emptyException) {
        return new ResponseEntity<>(new ResponseDTO(emptyException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}
