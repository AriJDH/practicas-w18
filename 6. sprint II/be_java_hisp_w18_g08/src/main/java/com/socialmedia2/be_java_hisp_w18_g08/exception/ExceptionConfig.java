package com.socialmedia2.be_java_hisp_w18_g08.exception;

import com.socialmedia2.be_java_hisp_w18_g08.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ExceptionDto> notFoundUserException(Exception e){
        List<String> messages = new ArrayList<>();
        messages.add(e.getMessage());
        ExceptionDto eDTO = new ExceptionDto(messages, 404,LocalDateTime.now());
        return new ResponseEntity<>(eDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class
    })
    public ResponseEntity<ExceptionDto> badRequestException(Exception e){
        List<String> messages = new ArrayList<>();
        messages.add(e.getMessage());
        ExceptionDto eDTO = new ExceptionDto(messages, 400,LocalDateTime.now());
        return new ResponseEntity<>(eDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> catchValidation(MethodArgumentNotValidException ex){
        List<String> messages = ex.getFieldErrors().stream().map(m->m.getDefaultMessage()).collect(Collectors.toList());
        ExceptionDto response = new ExceptionDto(messages,400, LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> catchValidation(ConstraintViolationException ex){
        List<String> messages = List.of(ex.getMessage());
        ExceptionDto response = new ExceptionDto(messages,400, LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
