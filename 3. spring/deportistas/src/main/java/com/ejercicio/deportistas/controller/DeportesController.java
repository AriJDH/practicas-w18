package com.ejercicio.deportistas.controller;

import com.ejercicio.deportistas.dto.DeporteDTO;
import com.ejercicio.deportistas.dto.DeporteDTONivel;
import com.ejercicio.deportistas.dto.DeportistaDTO;
import com.ejercicio.deportistas.service.DeportesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {
    private DeportesService service = new DeportesService();

    /**
     * Ver todos los deportes que tenemos cargados.
     *
     * @return
     */
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> traerTodosLosDeportes() {
        return ResponseEntity.ok(service.getAllSports());
    }

    /**
     * Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar
     * la clase ResponseEntity para devolver la respuesta.
     */
    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTONivel> traerDeporte(@PathVariable String name) {
        return ResponseEntity.ok(service.findSport(name));
    }

    /**
     * Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y
     * el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para
     * este punto es importante valerse de un DTO.
     *
     * @return
     */
    @GetMapping("/findSportsPeople")
    public ResponseEntity<List<DeportistaDTO>> traerPersonasDeportistas() {
        return ResponseEntity.ok(service.findSportsPeople());
    }

}
