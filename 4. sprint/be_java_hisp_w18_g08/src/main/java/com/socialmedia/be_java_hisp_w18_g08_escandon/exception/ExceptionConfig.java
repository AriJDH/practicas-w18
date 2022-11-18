package com.socialmedia.be_java_hisp_w18_g08_escandon.exception;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ExceptionDto> notFoundUserException(Exception e){
        ExceptionDto eDTO = new ExceptionDto(e.getMessage(), 404);
        return new ResponseEntity<>(eDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class
    })
    public ResponseEntity<ExceptionDto> badRequestException(Exception e){
        ExceptionDto eDTO = new ExceptionDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDTO, HttpStatus.BAD_REQUEST);
    }
}
