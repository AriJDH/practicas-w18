package com.example.siniestros.controlller;

import com.example.siniestros.DTOs.ResponseDTO;
import com.example.siniestros.DTOs.SiniestroDTO;
import com.example.siniestros.service.SiniestroDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {
    @Autowired
    private SiniestroDbService siniestroDbService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        siniestroDbService.createSiniestro(siniestroDTO);
        return ResponseEntity.ok(new ResponseDTO("El siniestro fue creado de forma existosa.", 200));
    }
}
