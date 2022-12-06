package com.example.joyeria.controller;

import com.example.joyeria.dto.request.JoyaCompletaDTOReq;
import com.example.joyeria.dto.request.JoyaDTOReq;
import com.example.joyeria.dto.response.JoyaDTORes;
import com.example.joyeria.service.IJoyaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private final IJoyaService joyaService;


    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    ResponseEntity<String> create(@RequestBody JoyaDTOReq joyaDTOReq){
        Long id = joyaService.create(joyaDTOReq);
        return new ResponseEntity<>("Has creado la joya número "+id, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<JoyaDTORes>> findAll(){
        return new ResponseEntity<>(joyaService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<JoyaDTORes> findById(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteJoya(@PathVariable Long id){
        joyaService.deleteJoya(id);
        return new ResponseEntity<>("Eliminación exitosa",HttpStatus.OK);

    }

    @PutMapping("/update/{id_modificar}")
    ResponseEntity<String>  updateJoya(@RequestBody JoyaCompletaDTOReq joyaCompletaDTOReq){
        joyaService.update(joyaCompletaDTOReq);
        return new ResponseEntity<>("Se actualizó la joya número "+joyaCompletaDTOReq.getId(),HttpStatus.OK);
    }

}
