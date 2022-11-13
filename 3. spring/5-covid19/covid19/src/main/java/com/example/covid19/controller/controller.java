package com.example.covid19.controller;

import com.example.covid19.dto.request.PersonaDTOrequest;
import com.example.covid19.dto.request.SintomaDTOrequest;
import com.example.covid19.service.IServer;
import com.example.covid19.service.ServerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    IServer iServer = new ServerImpl();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTOrequest>> findSymptom(){
        return new ResponseEntity<>(iServer.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTOrequest> findSymtom(String name){
        return new ResponseEntity<>(iServer.findSymptom(name),HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTOrequest>> findRiskPerson(){
        return new ResponseEntity<>(iServer.findRiskPerson(),HttpStatus.OK);
    }

}
