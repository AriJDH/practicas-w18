package com.yuh.deportistas.controller;

import com.yuh.deportistas.dto.response.DeporteListDTORes;
import com.yuh.deportistas.dto.response.DeporteNivelListDTORes;
import com.yuh.deportistas.entity.Deporte;
import com.yuh.deportistas.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportesController {

    @GetMapping("/findSports")
    public ResponseEntity<DeporteListDTORes> getDeportes() {
        List<Deporte> deporteList = createDeportes();
        List<String> stringListDeportes = new ArrayList<>();
        for (Deporte deporte : deporteList) {
            stringListDeportes.add(deporte.getName());
        }
        DeporteListDTORes deporteListDTORes = new DeporteListDTORes(stringListDeportes);
        return new ResponseEntity<>(deporteListDTORes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteNivelListDTORes> getNivelDeporte(@PathVariable String name) {
        List<Deporte> deporteList = createDeportes();

        List<String> deportes = deporteList.stream().
                filter(deporte->deporte.getName().equals(name)).
                map(Deporte::getLevel).
                collect(Collectors.toList());

        DeporteNivelListDTORes deporteNivelListDTORes = new DeporteNivelListDTORes(deportes);
        return new ResponseEntity<>(deporteNivelListDTORes, HttpStatus.OK);
    }

    private List<Persona> createPersonas() {
        return null;
    }
    private List<Deporte> createDeportes() {
        List<Deporte> deporteList = new ArrayList<>();
        deporteList.add(new Deporte("Tennis", "Profesional"));
        deporteList.add(new Deporte("Volleyball", "Semi"));
        deporteList.add(new Deporte("Volleyball", "Profesional"));
        deporteList.add(new Deporte("Rugby", "Amateur"));
        return deporteList;
    }
}
