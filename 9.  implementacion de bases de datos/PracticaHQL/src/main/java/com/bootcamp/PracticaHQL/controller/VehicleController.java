package com.bootcamp.PracticaHQL.controller;

import com.bootcamp.PracticaHQL.dto.req.VehicleDto;
import com.bootcamp.PracticaHQL.dto.view.VehicleMatriculaMarcaModeloAndTotalPerdidaDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteAndMarcaDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteMarcaModeloDto;
import com.bootcamp.PracticaHQL.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> create(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(service.create(vehicleDto), HttpStatus.CREATED);
    }
    @GetMapping("/findAllByPatente")
    public ResponseEntity<List<VehiclePatenteDto>> findAllByPatente(){
        return new ResponseEntity<>(service.findAllByPatente(),HttpStatus.OK);
    }
    @GetMapping("/findAllByPatenteAndMarca")
    public ResponseEntity<List<VehiclePatenteAndMarcaDto>> findAllByPatenteAndMarca(){
        return new ResponseEntity<>(service.findAllByPatenteAndMarca(),HttpStatus.OK);
    }
    @GetMapping("/findAllPatentesByRuedasAndAnioFabricacion")
    public ResponseEntity<List<VehiclePatenteDto>> findAllPatentesByRuedasAndAnioFabricacion(){
        return new ResponseEntity<>(service.findAllPatenteByRuedasAndAnioFabricacion(),HttpStatus.OK);
    }

    @GetMapping("/findByPatenteMarcaModeloBySinister")
    public ResponseEntity<List<VehiclePatenteMarcaModeloDto>> findByPatenteMarcaModeloBySinister(){
        return new ResponseEntity<>(service.findByPatenteMarcaModeloBySinister(),HttpStatus.OK);
    }

    @GetMapping("/findByPatenteMarcaModeloAndPerdidaBySinister")
    public ResponseEntity<VehicleMatriculaMarcaModeloAndTotalPerdidaDto> findByPatenteMarcaModeloAndPerdidaBySinister(){
        return new ResponseEntity<>(service.findByPatenteMarcaModeloAndPerdidaBySinister(),HttpStatus.OK);
    }
}
