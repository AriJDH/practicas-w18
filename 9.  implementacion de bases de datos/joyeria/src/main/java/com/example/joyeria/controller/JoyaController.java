package com.example.joyeria.controller;

import com.example.joyeria.dto.request.JoyaDtoReq;
import com.example.joyeria.dto.response.JoyaDtoRsp;
import com.example.joyeria.dto.response.ResponseDTO;
import com.example.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createdJewerly(@RequestBody JoyaDtoReq joya){
        Long id = joyaService.saveJoya(joya);
        return ResponseEntity.ok(new ResponseDTO(200,"Operación exitosa. Su nro identificatorio es: " + id));
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getJewels(){
        List<JoyaDtoRsp> joyas = joyaService.getJoyas();
        return ResponseEntity.ok(joyas);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<?> getJewerly(@PathVariable Long id){
        return ResponseEntity.ok(joyaService.findJoya(id));
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id ){
        joyaService.deleteJoya(id);
        return ResponseEntity.ok(new ResponseDTO(200,"La joya se ha eliminado correctamente"));
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updatJewerly(@PathVariable Long id, @RequestBody JoyaDtoReq joya){
        joyaService.modifyJoya(id, joya);
        return ResponseEntity.ok(new ResponseDTO(200,"La joya se ha modificado exitosamente"));
    }
}
