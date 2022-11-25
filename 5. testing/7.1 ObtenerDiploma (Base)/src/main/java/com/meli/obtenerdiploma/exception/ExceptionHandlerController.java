package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.util.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
// Slf4j lo usamos para imprimir el error y dejar registro
@Slf4j
public class ExceptionHandlerController {
	
	// Todos los métodos que usamos para manejar excepciones empiezan con el ExceptionHandler
	// y con  la clase de Excepción que queremos atrapar y manejar
	@ExceptionHandler(MethodArgumentNotValidException.class)
	// Vamos a devolver un ResponseEntity pero todavía no sabemos su contenido, por eso usamos el <?>
	public ResponseEntity<?> handleValidationExceptions
					(MethodArgumentNotValidException e) { // Recibimos por parámetro la Excepción
		
		// Buena práctica: imprimimos el error con un log
		log.error("El campo es requerido", e);
		
		// Vamos a guardar la lista de errores que obtenemos de la excepción:
		List<FieldError> fieldErrors = e
						.getBindingResult() // Obtenemos el listado de errores con su detalle
						.getFieldErrors(); // Obtenemos los campos (field) donde hay errores
		
		// Vamos a mapear el listado de campos de error para devolver una lista completa
		// los errores y su detalle a través del Response Entity
		List<ErrorDto> collect = fieldErrors
						.stream()
						.map(fieldError ->
										// Creamos un DTO para organizar mejor la respuesta
										new ErrorDto(String
														.format("El campo %s posee un error: %s", // el %s quiere decir que
																		// por cada uno se reemplazará por lo que está después de la coma
																		fieldError.getField(), // El primer %s es reemplazado por el campo(field)
																		fieldError.getDefaultMessage()))) // El segundo %s es reemplazado por el mensaje
						.collect(Collectors.toList());
		// Devolvemos una respuesta con la lista de errores en DTO y su correspondiente HTTP Status
		return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
	}
	
}
