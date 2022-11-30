package com.example.socialmeli2.exception;

import com.example.socialmeli2.dto.response.ErrorResponse;
import com.example.socialmeli2.dto.response.ErrorValidationListResponse;
import com.example.socialmeli2.dto.response.ErrorValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> MethodArgumentTypeMismatchException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("Se introdujo un tipo de parámetro incorrecto al requerido", 404);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturandoValidaciones(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
        List<ErrorValidationResponse> errorValidationResponseList = new ArrayList<>();

        for (FieldError fieldError : fieldErrorList) {
            errorValidationResponseList.add(new ErrorValidationResponse(
                    fieldError.getField(),
                    fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage()));
        }

        return new ResponseEntity<>(new ErrorValidationListResponse(errorValidationResponseList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e) {
        ErrorResponse ErrorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(ErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
