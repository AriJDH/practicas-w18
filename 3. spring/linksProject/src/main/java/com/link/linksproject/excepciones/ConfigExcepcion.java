package com.link.linksproject.excepciones;

import com.link.linksproject.dto.ExcepcionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ConfigExcepcion {

    @ExceptionHandler(URLInvalidaExcepcion.class)
    public ResponseEntity<ExcepcionDTO> urlInvalidaExcepcion(Exception e){
        ExcepcionDTO exDTO = new ExcepcionDTO();
        exDTO.setMessage(e.getMessage());
        exDTO.setStatus(400);

        return new ResponseEntity<>(exDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ExcepcionDTO> notFoundLinkException(Exception e){
        ExcepcionDTO exDTO = new ExcepcionDTO();
        exDTO.setMessage(e.getMessage());
        exDTO.setStatus(404);

        return new ResponseEntity<>(exDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordErrorException.class)
    public ResponseEntity<ExcepcionDTO> passwordError(Exception e){
        ExcepcionDTO exDTO = new ExcepcionDTO();
        exDTO.setMessage(e.getMessage());
        exDTO.setStatus(400);

        return new ResponseEntity<>(exDTO, HttpStatus.BAD_REQUEST);
    }

}
