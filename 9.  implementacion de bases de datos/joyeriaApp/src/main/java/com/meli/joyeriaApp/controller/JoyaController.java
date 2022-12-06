package com.meli.joyeriaApp.controller;


import com.meli.joyeriaApp.dtos.ResponseDTO;
import com.meli.joyeriaApp.model.Joya;
import com.meli.joyeriaApp.service.JoyaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    private JoyaDbService joyaDbService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createJoya(@RequestBody Joya joya){
        Joya savedJoya = joyaDbService.save(joya);
        return ResponseEntity.ok(new ResponseDTO("Se creó la joya con id " + savedJoya.getNro_identificatorio() + ".", 200));
    }

    @GetMapping("")
    public ResponseEntity<List<Joya>> findAll(){
        return ResponseEntity.ok(joyaDbService.findAllJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteJoya(@PathVariable Long id){
        joyaDbService.deleteById(id);
        return ResponseEntity.ok(new ResponseDTO("La joya de id " + id + " fue elimada exitosamente.", 200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateJoya(@PathVariable Long id, @RequestBody Joya joya){
        joyaDbService.update(id, joya);
        return ResponseEntity.ok(new ResponseDTO("La joya de id " + id + " fue actualizada exitosamente.", 200));
    }
}
