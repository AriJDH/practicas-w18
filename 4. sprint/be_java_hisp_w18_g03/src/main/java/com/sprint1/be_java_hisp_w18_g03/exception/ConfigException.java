package com.sprint1.be_java_hisp_w18_g03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler
    public ResponseEntity<?> noFoundUserException(NoFoundUserException noFoundUserException) {
        return null;
    }
}
