package com.covid19.covid19.controllers;

import com.covid19.covid19.database.Seed;
import com.covid19.covid19.dtos.response.SymptomDTORes;
import com.covid19.covid19.entities.Level;
import com.covid19.covid19.entities.Symptom;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.EntityDeclaration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/symptoms")
public class SymptomController {

    private Seed repo = new Seed();

    @GetMapping()
    public ResponseEntity<List<SymptomDTORes>> findSymptoms() {
        List<SymptomDTORes> symptoms = repo.getSymptoms().stream()
                .map(s -> new SymptomDTORes(s.getName(), s.getLevel()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(symptoms, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SymptomDTORes> findSymptomByName(@PathVariable String name) {
        SymptomDTORes symptomDTORes;
        Optional<SymptomDTORes> optionalSymptom = repo.getSymptoms().stream()
                .filter(s -> s.getName().equals(name))
                .map(s -> new SymptomDTORes(s.getName(), s.getLevel()))
                .findFirst();

        if (!optionalSymptom.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        symptomDTORes = optionalSymptom.get();
        return new ResponseEntity<>(symptomDTORes, HttpStatus.OK);
    }
}
