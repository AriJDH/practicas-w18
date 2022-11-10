package com.sports.sports.controllers;

import com.sports.sports.models.DTO.PersonDTO;
import com.sports.sports.models.DTO.SportsDTO;
import com.sports.sports.models.Person;
import com.sports.sports.models.Sport;
import com.sports.sports.repository.Seed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AppController {

    private Seed repo = new Seed();

    @GetMapping("/findsports")
    public ResponseEntity<List<SportsDTO>> findSports(){
        List<SportsDTO> sportsDTO = repo.getSports().stream()
                .map(v1 -> new SportsDTO(v1.getName(),v1.getLvl(),""))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sportsDTO, HttpStatus.OK);
    }

    @GetMapping("/findsport/{name}")
    public ResponseEntity<SportsDTO> findSport(@PathVariable String name) {
        Optional<SportsDTO> sportDTO = repo.getSports().stream()
                .filter(v1 -> v1.getName().compareTo(name) == 0)
                .map(v1 -> new SportsDTO(v1.getName(),v1.getLvl(),"Se ha encontrado su deporte"))
                .findFirst();
        if (sportDTO.isEmpty()) {
            SportsDTO sportsDTO = new SportsDTO(null,null,"Su deporte no existe señor :C");
            return new ResponseEntity<>(sportsDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sportDTO.get(), HttpStatus.OK);
    }

    @GetMapping("/findsportspersons")
    public ResponseEntity<List<PersonDTO>> findPersonSport() {
        List<PersonDTO> personsDTO = repo.getPersons().stream()
                .filter(v1 -> v1.getPersonSport() != null)
                .map(v1 -> new PersonDTO(v1.getName(),v1.getLastname(),v1.getPersonSport().getName()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(personsDTO, HttpStatus.OK);
    }

    @GetMapping("/findpersons")
    public ResponseEntity<List<PersonDTO>> findPerson() {
        List<PersonDTO> personsDTO = repo.getPersons().stream()
                .map(v1 -> new PersonDTO(v1.getName(),v1.getLastname(),null))
                .collect(Collectors.toList());
        return new ResponseEntity<>(personsDTO, HttpStatus.OK);
    }
}
