package com.mercadolibre.cuentacalorias.controller;

import com.mercadolibre.cuentacalorias.dto.request.PlatoDTOReq;
import com.mercadolibre.cuentacalorias.dto.request.PlatoDTOCreate;
import com.mercadolibre.cuentacalorias.service.IIngredienteService;
import com.mercadolibre.cuentacalorias.service.IPlatoService;
import com.mercadolibre.cuentacalorias.service.IngredienteService;
import com.mercadolibre.cuentacalorias.service.PlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatosController {
    IPlatoService platoService;
    IIngredienteService ingredienteService;

    public PlatosController(PlatoService platoService, IngredienteService ingredienteService) {
        this.platoService = platoService;
        this.ingredienteService = ingredienteService;
    }

    @PostMapping("/calcularCalorias/plato")
    public ResponseEntity<PlatoDTOReq> calcularCaloriasPlato(@RequestBody PlatoDTOReq plato){
        //TODO
        return null;
    }

    @PostMapping("/calcularCalorias/platos")
    public ResponseEntity<List<PlatoDTOReq>> calcularCaloriasPlato(@RequestBody List<PlatoDTOReq> platos){
        //TODO
        return null;
    }

    @PostMapping("/crearPlato")
    public ResponseEntity<?> crearPlato(@RequestBody PlatoDTOCreate plato){
        //TODO
        return null;
    }
}
