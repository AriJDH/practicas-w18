package com.example.repaso.controller;

import com.example.repaso.entity.Deporte;
import com.example.repaso.entity.Persona;
import com.example.repaso.entity.dto.DeporteDTO;
import com.example.repaso.entity.dto.PersonaDTO;
import com.example.repaso.repository.DeporteRepository;
import com.example.repaso.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTO>> findSports(){
        ArrayList<Deporte> deportesEntity = DeporteRepository.getDeportes();
        ArrayList<DeporteDTO> deportesDTO = new ArrayList<>();

        for (Deporte e:deportesEntity) {
            deportesDTO.add(new DeporteDTO(e.getName(), e.getNivel()));
        }

        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        Deporte entity = DeporteRepository.findDeporte(name);
        return entity != null?
                new ResponseEntity<>(new DeporteDTO(entity.getName(), entity.getNivel()), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons(){
        List<Persona> personasEntity = PersonaRepository.findSportsPersons();
        List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();

        for(Persona pe: personasEntity){
            ArrayList<DeporteDTO> deportesDTO = new ArrayList<>();
            for(Deporte de : pe.getDeportesFrecuentes()){
                deportesDTO.add(new DeporteDTO(de.getName(), de.getNivel()));
            }
            personasDTO.add(new PersonaDTO(pe.getName(), pe.getLastName(), deportesDTO));
        }

        return new ResponseEntity<>(personasDTO, HttpStatus.OK);
    }
}
