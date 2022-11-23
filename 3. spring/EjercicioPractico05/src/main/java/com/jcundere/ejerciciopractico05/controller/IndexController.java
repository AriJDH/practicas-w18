package com.jcundere.ejerciciopractico05.controller;

import com.jcundere.ejerciciopractico05.DTO.response.PersonaResponse;
import com.jcundere.ejerciciopractico05.DTO.response.SintomaResponse;
import com.jcundere.ejerciciopractico05.entity.PersonaEntity;
import com.jcundere.ejerciciopractico05.repository.PersonaRepositoryImpl;
import com.jcundere.ejerciciopractico05.repository.SintomaRepositoryImpl;
import com.jcundere.ejerciciopractico05.utils.mapper.PersonaMapper;
import com.jcundere.ejerciciopractico05.utils.mapper.SintomaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IndexController {

    PersonaRepositoryImpl personaRepository = new PersonaRepositoryImpl();
    SintomaRepositoryImpl sintomaRepository = new SintomaRepositoryImpl();


    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaResponse>> getAllSymptom() {

        List<SintomaResponse> response = SintomaMapper.sintomaEntityList2SintomaResponseList(sintomaRepository.traeTodos());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaResponse> findSymptomByName(@PathVariable String name) {

        SintomaResponse response = new SintomaResponse();
        if (sintomaRepository.buscar(name).isPresent()) {
            response = SintomaMapper.sintomaEntity2SintomaResponse(sintomaRepository.buscar(name).get());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaResponse>> getAllPersonByRiskFilter() {

        List<PersonaEntity> personaEntityList = personaRepository.traeTodos();
        personaEntityList = personaEntityList
                .stream()
                .filter(personaEntity -> personaEntity.getEdad() >= 60)
                .filter(personaEntity -> personaEntity.getSintomaAsociadoList().size() > 0)
                .collect(Collectors.toList());

        List<PersonaResponse> response = PersonaMapper.personaEntityWithRiskList2PersonaResponseWithRiskList(personaEntityList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
