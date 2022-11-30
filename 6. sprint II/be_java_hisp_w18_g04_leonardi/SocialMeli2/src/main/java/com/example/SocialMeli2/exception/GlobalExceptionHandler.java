package com.example.SocialMeli2.exception;

import com.example.SocialMeli2.dto.respose.exception.ErrorDTO;
import com.example.SocialMeli2.dto.respose.exception.ErrorValidationDTO;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> BadRequestException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserNotFoundException(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(404, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> ConstraintViolationException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(422, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ErrorDTO> TypeMismatchException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> MissingServletRequestParameterException(MissingServletRequestParameterException e){
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(400, e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorValidationDTO> validatingDataTypes (
            MethodArgumentNotValidException exception
    ) {
        ErrorValidationDTO errorDTO = new ErrorValidationDTO();
        errorDTO.setStatus(HttpStatus.BAD_REQUEST);
        errorDTO.setName("Field Not Valid Exception");
        errorDTO.setMessage("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception
                .getFieldErrors()
                .forEach(
                        e -> {
                            String       field       = e.getField();
                            String       msg         = e.getDefaultMessage();
                            List<String> errorFields = new ArrayList<>();
                            if (errors.containsKey(e.getField())) {
                                errorFields = errors.get(field);
                            }
                            errorFields.add(msg);
                            errors.put(field, errorFields);
                        }
                );
        errorDTO.setErrorFields(errors);

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
