package com.mercadolibre.socialmeli2.exception;

import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundHandler(NotFoundException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 404);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(404));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentHandler(IllegalArgumentException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestHandler(BadRequestException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableHandler(HttpMessageNotReadableException e){
        ResponseDto eDto = new ResponseDto("Datos no compatibles", 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<String> messages = e.getFieldErrors().stream()
                .map(f-> f.getDefaultMessage())
                .collect(Collectors.toList());
        //e.getStackTrace();
        ResponseDto eDto = new ResponseDto(messages, 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));
    }

    @ExceptionHandler(OrderInvalidException.class)
    public ResponseEntity<?> orderInvalidExceptionHandler(OrderInvalidException e){
        ResponseDto eDto = new ResponseDto(e.getMessage(), 400);
        return new ResponseEntity<>(eDto, HttpStatus.valueOf(400));
    }

}
