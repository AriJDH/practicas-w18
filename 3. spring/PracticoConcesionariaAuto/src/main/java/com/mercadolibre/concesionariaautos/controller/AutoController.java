package com.mercadolibre.concesionariaautos.controller;

import com.mercadolibre.concesionariaautos.dto.AutoRequestDto.AutoRequestDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseNoServiceDto;
import com.mercadolibre.concesionariaautos.service.AutoService;
import com.mercadolibre.concesionariaautos.service.IAutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class AutoController {
    IAutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<AutoRequestDto> agregarAuto(@RequestBody AutoRequestDto autoRequestDto){
        autoService.agregarAuto(autoRequestDto);
        return new ResponseEntity<>(autoRequestDto, HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<AutoResponseNoServiceDto>> mostrarAutos(){
        return ResponseEntity.ok(autoService.verListadoAutos());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<AutoResponseDto>> listaAutosPorFecha(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(autoService.verAutosSegunFecha(since, to));
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<AutoResponseDto>> listaAutoPorPrecio(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(autoService.verAutosSegunPrecio(since, to));
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<AutoResponseDto> verAutoInformacion(@PathVariable String id){
        return ResponseEntity.ok(autoService.verAuto(id));
    }

}
