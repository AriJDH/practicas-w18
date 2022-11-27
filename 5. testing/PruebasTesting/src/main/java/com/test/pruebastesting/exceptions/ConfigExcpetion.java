package com.test.pruebastesting.exceptions;

import com.test.pruebastesting.dto.MensajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigExcpetion {

    @ExceptionHandler(ExcepcionesGenerales.class)
    public ResponseEntity<MensajeDTO> excepcionesGenerales(Exception e){
        MensajeDTO mensaje = new MensajeDTO();
        mensaje.setMessage(e.getMessage());
        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
    }
}
