package com.meli.starwars.exception;

import com.meli.starwars.dto.ErrorListDTO;
import com.meli.starwars.dto.GenericErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundException(NoFoundException noFoundException) {
        return new ResponseEntity<>(new GenericErrorDTO(noFoundException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, WebRequest request) {
        Map<String, String> errorsMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(new ErrorListDTO(errorsMap), HttpStatus.BAD_REQUEST);
    }
}
