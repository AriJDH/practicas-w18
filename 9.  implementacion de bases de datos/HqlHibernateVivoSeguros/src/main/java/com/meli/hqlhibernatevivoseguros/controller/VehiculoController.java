package com.meli.hqlhibernatevivoseguros.controller;

import com.meli.hqlhibernatevivoseguros.dto.PatenteListDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaListDTO;
import com.meli.hqlhibernatevivoseguros.service.VehiculoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoController {

    @Autowired
    VehiculoServiceImp vehiculoServiceImp;

    @GetMapping("/selectAllPatentes")
    public ResponseEntity<PatenteListDTO> listarPatentes() {
        return new ResponseEntity<>(vehiculoServiceImp.listarPatentes(), HttpStatus.OK);
    }

    @GetMapping("/selectAllPatentesMarcasOrdenadoPorAnio")
    public ResponseEntity<PatenteMarcaListDTO> listarPatentesMarcasOrdenadoPorAnio() {
        return new ResponseEntity<>(vehiculoServiceImp.listarPatenteMarcaOrderByAnioFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/selectAllPatentesVehiculosFabricadosAnioActualConCuatroRuedass")
    public ResponseEntity<PatenteListDTO> listarPatentesVehiculosFabricadosAnioActualConCuatroRuedass() {
        return new ResponseEntity<>(vehiculoServiceImp.listarPatentesVehiculosCuatroRuedasFabricadosAnioActual(), HttpStatus.OK);
    }

}
