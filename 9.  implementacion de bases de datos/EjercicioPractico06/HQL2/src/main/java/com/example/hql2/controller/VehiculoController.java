package com.example.hql2.controller;

import com.example.hql2.dto.response.VehiculoResponse;
import com.example.hql2.dto.response.VehiculoTotalDamageResponse;
import com.example.hql2.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    @GetMapping("/getAllPatentes")
    public ResponseEntity<List<VehiculoResponse>> getAllPatentes() {
        return new ResponseEntity<>(this.vehiculoService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatenteAndMarcaOrderByAnioDeFabricacion")
    public ResponseEntity<List<VehiculoResponse>> getAllPatenteAndMarcaOrderByAnioDeFabricacion() {
        return new ResponseEntity<>(this.vehiculoService.getAllPatenteAndMarcaOrderByAnioDeFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatenteWhereCantRuedasGreater4AndYearsEqualsTo")
    public ResponseEntity<List<VehiculoResponse>> getAllPatenteWhereCantRuedasGreater4AndYearsEqualsTo() {
        return new ResponseEntity<>(this.vehiculoService.getAllPatenteWhereCantRuedasGreater4AndYearsEqualsTo(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatenteAndMarcaAndModelWherePerdidaEconomicaEqualsTo10000")
    public ResponseEntity<List<VehiculoResponse>> getAllPatenteAndMarcaAndModelWherePerdidaEconomicaEqualsTo10000() {
        return new ResponseEntity<>(this.vehiculoService.getAllPatenteAndMarcaAndModelWherePerdidaEconomicaEqualsTo10000(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatenteAndMarcaAndModelAndTotalDamageWherePerdidaEconomicaEqualsTo10000")
    public ResponseEntity<VehiculoTotalDamageResponse> getAllPatenteAndMarcaAndModelAndTotalDamageWherePerdidaEconomicaEqualsTo10000() {
        return new ResponseEntity<>(
                this.vehiculoService.getAllPatenteAndMarcaAndModelAndTotalDamageWherePerdidaEconomicaEqualsTo10000(),
                HttpStatus.OK);
    }

}
