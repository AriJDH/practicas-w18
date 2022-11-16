package com.dh.be_java_hisp_w18_g10.exception;

import com.dh.be_java_hisp_w18_g10.dto.response.ErrorDTOres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BodyLessException.class)
    public ResponseEntity<?> blogEntryNotFoundException(BodyLessException e){
        ErrorDTOres err = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
