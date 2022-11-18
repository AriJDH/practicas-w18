package com.mercadolibre.covid.controller;

import com.mercadolibre.covid.service.ISaludService;
import com.mercadolibre.covid.service.SaludService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaludController {
    private final ISaludService servi;

    public SaludController(SaludService servi) {
        this.servi = servi;
    }

    /**
     * Ver todos los síntomas que tenemos cargados.
     */
    @GetMapping("/findSymptom")
    public ResponseEntity<List<?>> mostrarTodosSintomas() {
        //TODO
        return null;
    }

    /**
     * Consultar si existe un síntoma ingresando su nombre.
     * De existir, se deberá mostrar el nivel de gravedad del mismo.
     * Utilizar la clase ResponseEntity para devolver la respuesta.
     */
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> mostrarUnSintoma(@PathVariable String name){
        //TODO
        return null;
    }

    /**
     * Visualizar a las personas que puedan ser del grupo de riesgo. Para ello,
     * necesitamos visualizar un listado con el nombre y el apellido de aquellas
     * personas mayores de 60 años que puedan poseer al menos un síntoma asociado.
     * Como para la respuesta de esta consulta habrá que tener en cuenta la relación
     * entre las dos tablas, se recomienda utilizar el patrón DTO.
     */
    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> mostrarPersonasDeRiesgo(){
        //TODO
        return null;
    }

}
