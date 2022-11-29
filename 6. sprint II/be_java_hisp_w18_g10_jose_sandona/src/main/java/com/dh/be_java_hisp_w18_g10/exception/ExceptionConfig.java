package com.dh.be_java_hisp_w18_g10.exception;

import com.dh.be_java_hisp_w18_g10.dto.response.ErrorDTOres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BodyLessException.class)
    public ResponseEntity<?> blogEntryNotFoundException(BodyLessException e){
        ErrorDTOres err = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(UserNotFoundException e){
        ErrorDTOres err = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserIdNullException.class)
    public ResponseEntity<?> userIdNullException(UserIdNullException e){
        ErrorDTOres err = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UserGenericException.class)
    public ResponseEntity<ErrorDTOres> userGenericException(Exception ex){
        ErrorDTOres error = new ErrorDTOres(ex.getMessage(), 404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException e){
        ErrorDTOres errorDto = new ErrorDTOres(e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> validationExceptionHandler(HttpMessageNotReadableException e){
        ErrorDTOres errorDto = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationExceptionHandler(ConstraintViolationException e){
        ErrorDTOres errorDto = new ErrorDTOres(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }


}
