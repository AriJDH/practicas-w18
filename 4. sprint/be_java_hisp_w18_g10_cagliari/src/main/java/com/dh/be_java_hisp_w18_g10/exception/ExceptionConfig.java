package com.dh.be_java_hisp_w18_g10.exception;

import com.dh.be_java_hisp_w18_g10.dto.response.ErrorDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.ErrorUserNotFoundDTOres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(UserNotFoundException e){
        ErrorDTOres err = new ErrorUserNotFoundDTOres(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getUserId());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserIdNullException.class)
    public ResponseEntity<?> userIdNullException(UserIdNullException e){
        ErrorDTOres err = new ErrorDTOres(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDTOres> userGenericException(Exception e){
        ErrorDTOres error = new ErrorDTOres(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
