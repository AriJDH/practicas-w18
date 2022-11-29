package com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

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

    // * =============

    /**
     * Handler to handle ForbiddenException
     * @param e ForbiddenException
     * @return ResponseEntity<ErrorResponse> - (message, status)
     */

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbiddenException(ForbiddenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(HttpStatus.FORBIDDEN.value(), e.getMessage()));
    }

    // * =============

    /**
     * Handler to handle MethodArgumentNotValidException
     * @param e MethodArgumentNotValidException
     * @return ResponseEntity<ErrorResponse> - (message, status)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("status", HttpStatus.BAD_REQUEST.value(), "errors", errors));

    }

    // * =============

    /**
     * Handler to handle HttpMessageNotReadableException
     * @param e HttpMessageNotReadableException
     * @return ResponseEntity<ErrorResponse> - (message, status)
     */

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleValidationExceptions(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }



}
