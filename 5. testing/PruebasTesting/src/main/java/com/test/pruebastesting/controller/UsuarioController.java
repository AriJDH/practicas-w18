package com.test.pruebastesting.controller;

import com.test.pruebastesting.dto.UsuarioDTO;
import com.test.pruebastesting.serivce.IServiceGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IServiceGeneral service;

    @GetMapping()
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
        return new ResponseEntity<>(service.getAllUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable int id){
        return new ResponseEntity<>(service.getUsuario(id), HttpStatus.OK);
    }


}
