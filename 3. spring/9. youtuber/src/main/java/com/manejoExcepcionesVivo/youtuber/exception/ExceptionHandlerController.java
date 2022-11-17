package com.manejoExcepcionesVivo.youtuber.exception;

import com.manejoExcepcionesVivo.youtuber.util.ErrorMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
	
	@ExceptionHandler(IdDuplicadoException.class)
	public ResponseEntity<ErrorMessageDTO> duplicatedId(IdDuplicadoException e) {
		log.error("Id Duplicado", e);// Para imprimir en un log el error
		// Retornamos un status con un body formado por el DTO Error Message
		return ResponseEntity.status(409)
						.body(new ErrorMessageDTO(e));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> notFound(NoSuchElementException e) {
		log.error("Id no encontrado", e); // Va a mostrar error en consola
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // otra forma de respuesta
	}
}
