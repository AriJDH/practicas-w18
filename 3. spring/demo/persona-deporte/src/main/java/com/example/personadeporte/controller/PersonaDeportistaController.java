package com.example.personadeporte.controller;

import com.example.personadeporte.dto.PersonDTO;
import com.example.personadeporte.dto.SportDTO;
import com.example.personadeporte.dto.SportsmanDTOres;
import com.example.personadeporte.entity.Sport;
import com.example.personadeporte.entity.Sportsman;
import com.example.personadeporte.repository.SportRepository;
import com.example.personadeporte.repository.SportsmanRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaDeportistaController {

    @PostMapping("/addSport")
    public ResponseEntity<String> addSport(@RequestBody SportDTO sportToAdd) {
        Sport sport = new Sport(sportToAdd.getName(), sportToAdd.getLevel());
        SportRepository.addSport(sport);
        return new ResponseEntity<>("Deporte agregado correctamente", HttpStatus.CREATED);
    }

    @PostMapping("/addSportsman")
    public ResponseEntity<String> addPerson(PersonDTO personDto) {
        Sportsman sportsman = new Sportsman(personDto.getName(), personDto.getLastName(), personDto.getAge());
        SportsmanRespository.addSportsman(sportsman);
        return new ResponseEntity<>("Deportista agregado correctamente", HttpStatus.CREATED);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> getSports() {
        List<SportDTO> sportsDTO = new ArrayList<>();
        SportRepository
                .getSports()
                .forEach(s -> sportsDTO.add(new SportDTO(s.getName(), s.getLevel())));
        return new ResponseEntity<>(sportsDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<?> findSport(@PathVariable String sportName) {
        for (Sport sport : SportRepository.getSports()) {
            if (sport.getName().equals(sportName)) {
                return ResponseEntity.ok().body( "Level: " + sport.getLevel());
            }
        }
        return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsmanDTOres> > findSportsPersons() {
        List<SportsmanDTOres> res = new ArrayList<>();
        SportsmanRespository
                .getSportsmans()
                .forEach(s -> res
                        .add(new SportsmanDTOres(s.getName(),
                                s.getSports()
                                        .stream()
                                        .map(Sport::getName)
                                        .collect(Collectors.toList()))
                        ));

        return new ResponseEntity<>(res, HttpStatus.OK);
    }





}
