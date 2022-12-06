package com.example.qatesters.exception;
import com.example.qatesters.dto.response.ErrorDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TestCaseNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserNotFoundException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(404, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> ConstraintViolationException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(422, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ErrorDTO> TypeMismatchException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
