package com.meli.be_java_hisp_w18_g9.exception;

import com.meli.be_java_hisp_w18_g9.model.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler to handle all exceptions in controllers and return a custom response
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // ? ====================== Handlers ====================== ?

    /**
     * Handler to handle BadRequestException
     * @param e BadRequestException
     * @return ResponseEntity<ErrorResponse> - (message, status)
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    // * =============

    /**
     * Handler to handle NotFoundException
     * @param e NotFoundException
     * @return ResponseEntity<ErrorResponse> - (message, status)
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }


}
