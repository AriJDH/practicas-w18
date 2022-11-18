package com.socialmeli.be_java_hisp_w18g05.exceptions;

import com.socialmeli.be_java_hisp_w18g05.dto.response.ErrorExceptionDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    @ExceptionHandler
    public ResponseEntity<ErrorExceptionDTOResponse> alreadyExistsException(AlreadyExistsException alreadyExistsException) {
        return new ResponseEntity<>(
                new ErrorExceptionDTOResponse(alreadyExistsException.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);

    }
}
