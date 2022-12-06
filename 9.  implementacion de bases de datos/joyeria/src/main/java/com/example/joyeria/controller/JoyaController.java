package com.example.joyeria.controller;

import com.example.joyeria.dto.ConsultaJoyaOutDTO;
import com.example.joyeria.dto.CreacionJoyaDTO;
import com.example.joyeria.dto.ResultadoDTO;
import com.example.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoyaController {

    private IJoyaService iJoyaService;

    public JoyaController(IJoyaService iJoyaService) {
        this.iJoyaService = iJoyaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<ResultadoDTO> guardarJoya(@RequestBody CreacionJoyaDTO creacionJoyaDTO) {
        return new ResponseEntity<>(this.iJoyaService.guardarJoya(creacionJoyaDTO), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<ConsultaJoyaOutDTO> consultarJoyas() {
        return new ResponseEntity<>(this.iJoyaService.obtenerJoyas(), HttpStatus.OK);
    }
}
