package com.meli.hqlhibernatevivoseguros.controller;

import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloListDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloPerdidaListDTO;
import com.meli.hqlhibernatevivoseguros.service.SiniestroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiniestroController {

    @Autowired
    SiniestroServiceImp siniestroServiceImp;

    @GetMapping("/selectSiniestroMayorDeMilPesos")
    public ResponseEntity<MatriculaMarcaModeloListDTO> listarSiniestroMayorDeMilPesos() {
        return new ResponseEntity<>(siniestroServiceImp.listarSiniestroMayorDeMilPesos(), HttpStatus.OK);
    }

    @GetMapping("/selectSiniestroMayorDeMilPesosConPerdida")
    public ResponseEntity<MatriculaMarcaModeloPerdidaListDTO> listarSiniestroMayorDeMilPesosConPerdida() {
        return new ResponseEntity<>(siniestroServiceImp.listarSiniestroMayorDeMilPesosConPerdida(), HttpStatus.OK);
    }
}
