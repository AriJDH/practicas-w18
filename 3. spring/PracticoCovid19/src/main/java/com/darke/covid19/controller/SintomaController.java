package com.darke.covid19.controller;

import com.darke.covid19.dto.request.SintomaRequestDto;
import com.darke.covid19.dto.response.SintomaResponseDto;
import com.darke.covid19.service.ISintomaService;
import com.darke.covid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class SintomaController {
    //Dependency Injections
    ISintomaService sintomaService;

    public SintomaController(SintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @PostMapping("crearSintoma")
    public ResponseEntity<SintomaRequestDto> crearSintoma(@RequestBody SintomaRequestDto sintomaRequestDto){
        sintomaService.creaSintoma(sintomaRequestDto);
        return new ResponseEntity<>(sintomaRequestDto,HttpStatus.CREATED);
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaResponseDto>> getSintomas(){
        return ResponseEntity.ok(sintomaService.getSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String name){
        return ResponseEntity.ok(sintomaService.findSintoma(name));
    }
}
