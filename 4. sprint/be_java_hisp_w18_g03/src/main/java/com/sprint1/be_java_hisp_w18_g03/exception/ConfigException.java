package com.sprint1.be_java_hisp_w18_g03.exception;

import com.sprint1.be_java_hisp_w18_g03.dto.response.ErroValidationrDto;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ConfigException {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundException(NoFoundException noFoundException) {
        return new ResponseEntity<>(new ResponseDTO(noFoundException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreationException.class)
    public ResponseEntity<?> creationException(CreationException creationException) {
        return new ResponseEntity<>(new ResponseDTO(creationException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParamException.class)
    public ResponseEntity<?> paramException(ParamException paramException) {
        return new ResponseEntity<>(new ResponseDTO(paramException.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturandoValidaciones(MethodArgumentNotValidException e){
        List<String> messages = e.getFieldErrors().stream().map(error -> error.getField() + " -> " + error.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(new ErroValidationrDto(messages, 400, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e){
        List<String> messages = Arrays.asList(e.getMessage());
        return new ResponseEntity<>(new ErroValidationrDto(messages, 400, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> capturandoValidaciones(ConstraintViolationException e){
        List<String> messages = Arrays.asList(e.getMessage());
        return new ResponseEntity<>(new ErroValidationrDto(messages, 400, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
