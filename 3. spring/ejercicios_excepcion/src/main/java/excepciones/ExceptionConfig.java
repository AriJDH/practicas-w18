package excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noEncontrado(NoFoundException nfe) {
        return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
    }
}
