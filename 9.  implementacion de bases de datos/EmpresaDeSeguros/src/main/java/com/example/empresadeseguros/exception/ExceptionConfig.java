package com.example.empresadeseguros.exception;

import com.example.empresadeseguros.dto.response.ErrorExceptionDTOResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTOResponse> notFoundException(NotFoundException noFoundException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTOResponse(noFoundException.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
        List<ErrorExceptionDTOResponse> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorExceptionDTOResponse(error.getDefaultMessage(), HttpStatus.BAD_REQUEST.value()))
                .distinct()
                .collect(Collectors.toList());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // For arguments in parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationExceptions(ConstraintViolationException ex){
        ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e){
        ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
