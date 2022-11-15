package com.blog.blog_youtube.exception;

import com.blog.blog_youtube.dto.ErrorExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTO> createdException(CreatedException createdException) {

        ErrorExceptionDTO errorExceptionDTO = new ErrorExceptionDTO(
                createdException.getMessage(), HttpStatus.FORBIDDEN.value());

        return new ResponseEntity<>(errorExceptionDTO, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTO> noFoundException(NoFoundException noFoundException) {

        ErrorExceptionDTO errorExceptionDTO = new ErrorExceptionDTO(
                noFoundException.getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
