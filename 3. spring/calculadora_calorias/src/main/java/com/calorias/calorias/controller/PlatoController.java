package com.calorias.calorias.controller;

import com.calorias.calorias.dto.ResponsePlatoDTO;
import com.calorias.calorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PlatoController
{

    PlatoService platoService = new PlatoService();

    public PlatoController() throws IOException {
    }


    @GetMapping("/menu/plato/{idPlato}")
    public ResponseEntity<ResponsePlatoDTO> getPlato(@PathVariable Integer idPlato) {

        return new ResponseEntity<>(platoService.getPlato(idPlato), HttpStatus.OK);
    }

}
