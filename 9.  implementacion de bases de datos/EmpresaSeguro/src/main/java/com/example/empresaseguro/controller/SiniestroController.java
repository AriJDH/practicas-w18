package com.example.empresaseguro.controller;

import com.example.empresaseguro.dto.request.SiniestroDTORequest;
import com.example.empresaseguro.service.IServiceSiniestro;
import com.example.empresaseguro.service.ServiceSiniestroImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SiniestroController {
    IServiceSiniestro serviceSiniestro;
    public SiniestroController(ServiceSiniestroImp serviceSiniestro){
        this.serviceSiniestro = serviceSiniestro;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SiniestroDTORequest siniestroDTORequest){
        return new ResponseEntity<>(serviceSiniestro.crearSiniestro(), HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
    return new ResponseEntity<>(serviceSiniestro.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
    return new ResponseEntity<>(serviceSiniestro.findById(id));
    }
}

}
