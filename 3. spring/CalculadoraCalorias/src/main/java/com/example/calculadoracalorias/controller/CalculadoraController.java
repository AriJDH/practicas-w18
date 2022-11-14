package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CalculadoraController {

    @Autowired
    private ICalculadoraService calculadoraService;

    @GetMapping("/{plato}")
    public HashMap<String, Object> calcularCalorias(@PathVariable String plato) {

        HashMap<String, Object> datos = calculadoraService.getDatos(plato);

        return datos;
    }

    @GetMapping()
    public String HomeInstrucciones() {

        return "Para consultar un plato increse el nombre del plato en la url, ej: http://localhost:8080/Milanesa " +
                "Platos disponibles: Milanesa, Sushi, Ensalada";
    }

    @GetMapping("/lista")
    public List<HashMap<String, Object>> calcularCaloriasLista(@RequestParam List<String> platos) {

        List<HashMap<String, Object>> datos = new ArrayList<>();

        for(String plato : platos){
            datos.add(calculadoraService.getDatos(plato));
        }

        return datos;

    }

}
