package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.controller;

import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.dto.SintomaDTO;
import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model.Sintoma;
import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.repository.SintomaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SintomaController {

    private SintomaRepository sintomaRepository;

    public SintomaController() {
        this.sintomaRepository = new SintomaRepository();
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> buscarSintomas() {

        List<Sintoma> sintomas = this.sintomaRepository.consultarEntidades();

        List<SintomaDTO> sintomaDTOs = new ArrayList<>();

        for (Sintoma sintoma : sintomas) {
            sintomaDTOs.add(new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivel_de_gravedad()));
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Estado consulta", "Prueba lista");

        return new ResponseEntity<>(sintomaDTOs, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> consultarSintomaPorNombre(@PathVariable String name) {

        Sintoma sintoma = this.sintomaRepository.consultarEntidadPorNombre(name);

        if (sintoma == null) {
            return ResponseEntity.badRequest().header("error", "no se pudo").body(null);
        }

        SintomaDTO sintomaDTO = new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivel_de_gravedad());

        return ResponseEntity.ok(sintomaDTO);
    }
}
