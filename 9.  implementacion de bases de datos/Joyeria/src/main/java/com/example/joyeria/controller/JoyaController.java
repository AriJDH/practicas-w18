package com.example.joyeria.controller;

import com.example.joyeria.dto.MessageDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    @Autowired
    private JoyaService service;

    @PostMapping("/jewerly/new")
    public ResponseEntity<MessageDTO> createJoya(@RequestBody Joya joya){

        return new ResponseEntity<>(service.save(joya), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas(){
        return new ResponseEntity<>(service.getAllJoyas(),HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<Void> deleteJoya(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<MessageDTO> updateJoya(@RequestBody Joya joya, @PathVariable(name = "id_modificar") int id){
        return new ResponseEntity<>(service.update(joya,id),HttpStatus.OK);
    }
}
