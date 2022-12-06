package com.lasperlas.lasperlas.controller;

import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.dto.ResponseDTO;
import com.lasperlas.lasperlas.dto.UpdateDTO;
import com.lasperlas.lasperlas.service.IJoyasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyasController {
    @Autowired
    private IJoyasService joyasService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> create (@RequestBody JoyaDTO joyita) {
        ResponseDTO creado = joyasService.create(joyita);
        return ResponseEntity.status(creado.getStatus()).body(creado);
    }

    @GetMapping
    public  ResponseEntity<List<JoyaDTO>> getAll (){
        List<JoyaDTO> joyitas = joyasService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(joyitas);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
        ResponseDTO deleteado = joyasService.delete(id);
        return ResponseEntity.status(deleteado.getStatus()).body(deleteado);
    }

    @PutMapping("update/{id_modificar}")
    public ResponseEntity<ResponseDTO> update (@PathVariable Long id_modificar, @RequestBody UpdateDTO joyita){
        ResponseDTO updateado = joyasService.update(id_modificar,joyita);
        return ResponseEntity.status(updateado.getStatus()).body(updateado);
    }
}
