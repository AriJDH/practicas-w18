package com.meli.be_java_hisp_w18_g01.exceptions;

import com.meli.be_java_hisp_w18_g01.dtos.ErrorDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionsHandler {

    @ExceptionHandler({NotSellerException.class, BadRequestException.class, BadFollowException.class})
    public ResponseEntity<?> handleBadRequest(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> handleNotFound(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({UserAlreadyFollowedException.class})
    public ResponseEntity<?> handleConflict(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.CONFLICT.value(),
                        e.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ResponseDTO error = new ResponseDTO(400, e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ResponseDTO error = new ResponseDTO(400, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /*
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleServersideError(Exception e){
        return new ResponseEntity<>(
                new ResponseDTO(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Ha ocurrido un error en el servidor. Consulte con un administrador."),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
*/


    /*@ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> handleValidationExceptions
            (MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e
                .getBindingResult()
                .getFieldErrors();

        List<ErrorDTO> collect = fieldErrors
                .stream()
                .map(fieldError ->
                        new ErrorDTO(HttpStatus.BAD_REQUEST.value() ,String
                                .format("%s",
                                        fieldError.getDefaultMessage())))
                .collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.BAD_REQUEST);
    }*/

}
