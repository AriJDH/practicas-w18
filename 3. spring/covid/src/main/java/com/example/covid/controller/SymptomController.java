package com.example.covid.controller;

import com.example.covid.dto.SymptomDTORes;
import com.example.covid.service.ISymptomService;
import com.example.covid.service.SymptomServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {
    private final ISymptomService symptomService;

    public SymptomController(SymptomServiceImp symptomServiceImp) {
        this.symptomService = symptomServiceImp;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTORes>> findSymptom(){
        return new ResponseEntity<>(symptomService.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTORes> findSymptom(@PathVariable String name){
        return new ResponseEntity<>(symptomService.findSymptom(name), HttpStatus.OK);
    }
}
