package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.controller;

import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.dto.PersonajeDTO;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.service.IServicePersonaje;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.service.ServicePersonajeImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private IServicePersonaje iServicePersonaje = new ServicePersonajeImpl();

    @GetMapping("/consultarPersonajePorNombre/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> consultarPersonajePorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(iServicePersonaje.consultarPersonajesPorNombre(nombre), HttpStatus.OK);
    }
}
