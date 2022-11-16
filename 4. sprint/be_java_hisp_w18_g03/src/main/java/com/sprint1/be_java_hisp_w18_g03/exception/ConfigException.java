package com.sprint1.be_java_hisp_w18_g03.exception;

import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler
    public ResponseEntity<?> noFoundUserException(NoFoundUserException noFoundUserException) {
        return new ResponseEntity<>(new ResponseDTO(noFoundUserException.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
}
