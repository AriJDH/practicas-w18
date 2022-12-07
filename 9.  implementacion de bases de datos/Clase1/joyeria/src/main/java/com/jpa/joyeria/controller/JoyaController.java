package com.jpa.joyeria.controller;

import com.jpa.joyeria.dto.GenericResponseDTO;
import com.jpa.joyeria.model.Joya;
import com.jpa.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private JoyaService joyaService;

    public JoyaController(JoyaService joyaService){
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<GenericResponseDTO> createJoya(@RequestBody Joya joya){
        return new ResponseEntity(joyaService.save(joya), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas(){
        return new ResponseEntity<>(joyaService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<GenericResponseDTO> updateJoya(@RequestBody Joya joya, @PathVariable(name = "id_modificar") int id ){
        return new ResponseEntity<>(joyaService.update(joya, id),HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<GenericResponseDTO> deleteJoya(@PathVariable int id){
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.OK);
    }
}
