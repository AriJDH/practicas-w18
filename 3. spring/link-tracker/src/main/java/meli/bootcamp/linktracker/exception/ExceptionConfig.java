package meli.bootcamp.linktracker.exception;

import meli.bootcamp.linktracker.entity.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(Exception e)
    {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(),404);
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
