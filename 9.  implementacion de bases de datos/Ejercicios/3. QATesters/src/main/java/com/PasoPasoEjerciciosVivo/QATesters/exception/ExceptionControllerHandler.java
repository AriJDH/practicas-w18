package com.PasoPasoEjerciciosVivo.QATesters.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ExceptionControllerHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handlerNoSuchElementExceptions(NoSuchElementException e){
		log.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
