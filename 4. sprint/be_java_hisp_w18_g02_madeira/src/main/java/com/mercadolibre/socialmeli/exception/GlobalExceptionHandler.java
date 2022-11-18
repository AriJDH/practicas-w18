package com.mercadolibre.socialmeli.exception;

import com.mercadolibre.socialmeli.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto> notFoundHandler(NotFoundException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDto> illegalArgumentHandler(IllegalArgumentException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDto> badRequestHandler(BadRequestException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> httpMessageNotReadableHandler(HttpMessageNotReadableException e){
        ResponseDto eDto = new ResponseDto("Datos no compatibles", 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ResponseDto> ArithmeticExceptionHandler(ArithmeticException e) {
        ResponseDto eDto = new ResponseDto("Datos no compatibles", 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

}
