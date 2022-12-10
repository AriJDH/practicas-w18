package com.example.empresadeseguros.controller;

import com.example.empresadeseguros.dto.request.SiniestroNewDTORequest;
import com.example.empresadeseguros.dto.request.VehiculoNewDTORequest;
import com.example.empresadeseguros.dto.response.*;
import com.example.empresadeseguros.service.IServiceSiniestro;
import com.example.empresadeseguros.service.IServiceVehiculo;
import com.example.empresadeseguros.service.ServiceSiniestroImp;
import com.example.empresadeseguros.service.ServiceVehiculoImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerEmpresaDeSeguros {

    private final IServiceVehiculo iServiceVehiculo;
    private final IServiceSiniestro iServiceSiniestro;

    public ControllerEmpresaDeSeguros(ServiceVehiculoImp serviceVehiculoImp, ServiceSiniestroImp serviceSiniestroImp){
        this.iServiceVehiculo = serviceVehiculoImp;
        this.iServiceSiniestro = serviceSiniestroImp;
    }

    @GetMapping("/AllPatentes")
    public ResponseEntity<PatentesVehiculosDTOResponse> findAllVehiculos(){
        return new ResponseEntity<>(iServiceVehiculo.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/AllPatentesByAnio")
    public ResponseEntity<ListPatMarcaVehiculosDTOResponse> findAllVehiculosOrderbyAnio(){
        return new ResponseEntity<>(iServiceVehiculo.findAllVehiculosOrderbyAnio(), HttpStatus.OK);
    }

    @PostMapping("/Vehiculo")
    public ResponseEntity<?> nuevoVehiculo(@RequestBody VehiculoNewDTORequest vehiculoNewDTORequest){
        return new ResponseEntity<>("Vehiculo generado con id: " + iServiceVehiculo.nuevoVehiculo(vehiculoNewDTORequest), HttpStatus.CREATED);
    }
    @PostMapping("/Siniestro")
    public ResponseEntity<?> nuevoSiniestro(@RequestBody SiniestroNewDTORequest siniestroNewDTORequest){
        return new ResponseEntity<>("Siniestro generado con id: " + iServiceSiniestro.nuevoSiniestro(siniestroNewDTORequest), HttpStatus.CREATED);
    }

    @GetMapping("/Vehiculo/{id}")
    public ResponseEntity<VehiculoDTOResponse> vehiculoFindById(@PathVariable Integer id){
        return new ResponseEntity<>(iServiceVehiculo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/Siniestro/{id}")
    public ResponseEntity<SiniestroDTOResponse> siniestroFindById(@PathVariable Integer id){
        return new ResponseEntity<>(iServiceSiniestro.findById(id), HttpStatus.OK);
    }

    @GetMapping("/Vehiculos")
    public ResponseEntity<List<VehiculoDTOResponse>> vehiculoFindAll(){
        return new ResponseEntity<>(iServiceVehiculo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Siniestros")
    public ResponseEntity<List<SiniestroDTOResponse>> siniestroFindAll(){
        return new ResponseEntity<>(iServiceSiniestro.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Vehiculo/{id}/Siniestros")
    public ResponseEntity<VehiculoConSiniestrosDTOResponse> findByIdConSiniestros(@PathVariable Integer id){
        return new ResponseEntity<>(iServiceVehiculo.findByIdConSiniestros(id), HttpStatus.OK);
    }

}
