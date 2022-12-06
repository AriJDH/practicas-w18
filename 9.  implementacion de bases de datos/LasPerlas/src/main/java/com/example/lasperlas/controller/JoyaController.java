package com.example.lasperlas.controller;

import com.example.lasperlas.dto.GenericResponseDto;
import com.example.lasperlas.dto.JoyasDto;
import com.example.lasperlas.service.IJoyaService;
import com.example.lasperlas.service.imp.JoyaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(JoyaServiceImp joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<GenericResponseDto> create(@RequestBody JoyasDto joya){
        return new ResponseEntity<>(joyaService.create(joya), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JoyasDto>> findAll(){
        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyasDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> delete(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GenericResponseDto> update(@PathVariable Long id,
                                                     @RequestBody JoyasDto joya){
        return new ResponseEntity<>(joyaService.update(id, joya), HttpStatus.CREATED);
    }
}
