package com.mercadolibre.seguros.controller;

import com.mercadolibre.seguros.entity.otros.PatenteMarca;
import com.mercadolibre.seguros.service.IVehiculoService;
import com.mercadolibre.seguros.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SegurosController {
    private final IVehiculoService vehiculoService;

    public SegurosController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    /**
    Listar las patentes de todos los vehículos registrados.
     */
    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes(){
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }

    /**
     Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
     */
    @GetMapping("/patenteMarca")
    public ResponseEntity<List<HashMap<String, String>>> getPatenteMarcaOrdenadosPorAnio(){
        return new ResponseEntity<>(vehiculoService.getPatenteMarcaOrdenadosPorAnio(), HttpStatus.OK);
    }

    /**
     TODO Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
     */
    /**
     TODO Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
     */
    /**
     TODO Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos
     */

}
