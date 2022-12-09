package com.RecapitulandoSpringP2VIVO.linkTracker.exception;

import com.RecapitulandoSpringP2VIVO.linkTracker.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler(NotValidateLinkException.class)
	public ResponseEntity<?> notValidateLinkException(NotValidateLinkException e) {
		ErrorDto err = new ErrorDto(HttpStatus.CONFLICT.value(), e.getMessage());
		return new ResponseEntity<>(err, HttpStatus.CONFLICT);
	}
}