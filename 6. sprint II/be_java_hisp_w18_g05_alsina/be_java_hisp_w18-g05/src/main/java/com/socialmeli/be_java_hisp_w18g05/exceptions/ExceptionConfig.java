package com.socialmeli.be_java_hisp_w18g05.exceptions;

import com.socialmeli.be_java_hisp_w18g05.dto.response.ErrorExceptionDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ErrorValidationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTOResponse> invalidException(InvalidException invalidException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTOResponse(invalidException.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTOResponse> noFoundException(NotFoundException noFoundException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTOResponse(noFoundException.getMessage(), HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTOResponse> invalidParameterException(InvalidParameterException invalidParameterException){
        return new ResponseEntity<>(
                new ErrorExceptionDTOResponse(invalidParameterException.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);

    }
    // For arguments in methods
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
        List<ErrorValidationDTO> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorValidationDTO(error.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // For arguments in parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationExceptions(ConstraintViolationException ex){
        ErrorValidationDTO errorDto = new ErrorValidationDTO(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e){
        ErrorValidationDTO errorDto = new ErrorValidationDTO(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
