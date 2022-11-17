package com.socialmedia.be_java_hisp_w18_g08.exception;

import com.socialmedia.be_java_hisp_w18_g08.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ExceptionDTO> notFoundUserException(Exception e){
        ExceptionDTO eDTO = new ExceptionDTO(e.getMessage(), 400);
        return new ResponseEntity<>(eDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequestException(Exception e){
        ExceptionDTO eDTO = new ExceptionDTO(e.getMessage(), 400);
        return new ResponseEntity<>(eDTO, HttpStatus.BAD_REQUEST);
    }
}
