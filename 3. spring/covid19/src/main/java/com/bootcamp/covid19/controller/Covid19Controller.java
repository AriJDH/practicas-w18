package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.response.PersonaDtoResponse;
import com.bootcamp.covid19.dto.response.SintomaDtoResponse;
import com.bootcamp.covid19.service.Covid19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {
    Covid19Service covid19Service = new Covid19Service();
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDtoResponse>> findSymptom(){
        return new ResponseEntity<>(covid19Service.findSymptom(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<List<SintomaDtoResponse>> findSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(covid19Service.findSymptomByName(name), HttpStatus.OK);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDtoResponse>> findRiskPerson(){
        return new ResponseEntity<>(covid19Service.findRiskPerson(),HttpStatus.OK);
    }

}
