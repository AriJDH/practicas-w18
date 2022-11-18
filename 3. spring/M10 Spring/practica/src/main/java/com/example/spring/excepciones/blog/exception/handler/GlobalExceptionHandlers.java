package com.example.spring.excepciones.blog.exception.handler;

import com.example.spring.excepciones.blog.exception.EmptyException;
import com.example.spring.excepciones.blog.exception.IdNotExistExcep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


//maneja a todas las clases de excepciones personalizadas
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandlers {

    //Por parámetro le pasamos la clase que queremos que maneje
    @ExceptionHandler(IdNotExistExcep.class)
    public ResponseEntity<?> idNotExistException(IdNotExistExcep e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<?> emptyExceptionHandler(EmptyException e){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }


}
