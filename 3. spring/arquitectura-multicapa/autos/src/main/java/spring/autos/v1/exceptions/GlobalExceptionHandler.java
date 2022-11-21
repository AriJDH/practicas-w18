package spring.autos.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import spring.autos.v1.dto.ErrorDto;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        ErrorDto errorDto = new ErrorDto(e.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
