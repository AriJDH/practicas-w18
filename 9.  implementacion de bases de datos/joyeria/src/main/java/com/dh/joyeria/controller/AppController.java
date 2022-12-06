package com.dh.joyeria.controller;


import com.dh.joyeria.dto.JoyaDtoReq;
import com.dh.joyeria.dto.JoyaDtoRes;
import com.dh.joyeria.service.AppService;
import com.dh.joyeria.service.IAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class AppController {

    private final IAppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(
            @RequestBody JoyaDtoReq joyaDto){
        Long id = service.createJoya(joyaDto);
        return ResponseEntity.ok().body("nro identificario: " + id);
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        List<JoyaDtoRes> joyas = service.findAll();
        return new ResponseEntity<>(joyas, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(
            @PathVariable Long id){
        service.changeJoyaVentaONoToFalse(id);
        return ResponseEntity.ok().body("Joya changed");
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(
            @PathVariable Long id_modificar,
            @RequestBody JoyaDtoReq joyaDto){
        service.updateJoya(id_modificar, joyaDto);
        return ResponseEntity.ok().body("Joya updated");
    }



}
