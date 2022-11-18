package com.example.spring.dtoYResponseEntity.deporte.controller;

import com.example.spring.dtoYResponseEntity.deporte.dto.response.DeporteDTORes;
import com.example.spring.dtoYResponseEntity.deporte.entity.Deporte;
import com.example.spring.dtoYResponseEntity.deporte.repository.RepoDeportes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTORes>> findSports(){
        ArrayList<Deporte> deportesEntity = RepoDeportes.getDeportes();
        ArrayList<DeporteDTORes> deportesDTO = new ArrayList<DeporteDTORes>();

        for (Deporte d: deportesEntity) {
            deportesDTO.add(new DeporteDTORes(d.getName(), d.getNivel()));
        }
        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }


    @GetMapping("/findSports/{name}")
    public ResponseEntity<ArrayList<DeporteDTORes>> findSports(@PathVariable String name){
//todo
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
