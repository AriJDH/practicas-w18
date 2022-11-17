package com.covid19.covid19.controllers;

import com.covid19.covid19.database.Seed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private Seed repo = new Seed();

    @GetMapping("/")
    public ResponseEntity<List<RiskPersonDTORes>> findRiskPerson() {
        List<RiskPersonDTORes> riskPersons = repo.getPersons().stream()
                .map(p -> new RiskPersonDTORes(p.getName, p.getLastname))
                .collect(Collectors.toList());
        return new ResponseEntity<>(riskPersons, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTORes>> findRiskPerson() {
        List<RiskPersonDTORes> riskPersons = repo.getPersons().stream()
                .filter(p -> p.getAge() >= 60)
                .map(p -> new RiskPersonDTORes(p.getName(), p.getLastname()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(riskPersons, HttpStatus.OK);

    }
}