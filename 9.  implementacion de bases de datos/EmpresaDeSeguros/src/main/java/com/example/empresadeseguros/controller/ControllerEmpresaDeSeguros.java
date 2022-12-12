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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
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
    public ResponseEntity<?> nuevoVehiculo(@RequestBody @Valid VehiculoNewDTORequest vehiculoNewDTORequest){
        return new ResponseEntity<>("Vehiculo generado con id: " + iServiceVehiculo.nuevoVehiculo(vehiculoNewDTORequest), HttpStatus.CREATED);
    }
    @PostMapping("/Siniestro")
    public ResponseEntity<?> nuevoSiniestro(@RequestBody @Valid SiniestroNewDTORequest siniestroNewDTORequest){
        return new ResponseEntity<>("Siniestro generado con id: " + iServiceSiniestro.nuevoSiniestro(siniestroNewDTORequest), HttpStatus.CREATED);
    }

    @GetMapping("/Vehiculo/{id}")
    public ResponseEntity<VehiculoDTOResponse> vehiculoFindById(@PathVariable
                                                                    @NotNull(message = "Id no puede estar vacío")
                                                                    @Min(value = 1, message = "Id debe ser mayor a cero (0)") Integer id){
        return new ResponseEntity<>(iServiceVehiculo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/Siniestro/{id}")
    public ResponseEntity<SiniestroDTOResponse> siniestroFindById(@PathVariable
                                                                      @NotNull(message = "Id no puede estar vacío")
                                                                      @Min(value = 1, message = "Id debe ser mayor a cero (0)") Integer id){
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
    public ResponseEntity<VehiculoConSiniestrosDTOResponse> findByIdConSiniestros(@PathVariable
                                                                                      @NotNull(message = "Id no puede estar vacío")
                                                                                      @Min(value = 1, message = "Id debe ser mayor a cero (0)") Integer id){
        return new ResponseEntity<>(iServiceVehiculo.findByIdConSiniestros(id), HttpStatus.OK);
    }

    @GetMapping("/Vehiculos/4ruedas/currentDate")
    public ResponseEntity<PatentesVehiculosDTOResponse> findAllVehiculos4RuedasCurrentDate(){
        return new ResponseEntity<>(iServiceVehiculo.findAllVehiculos4RuedasCurrentDate(),HttpStatus.OK);
    }

    @GetMapping("/Vehiculos/perdidaEconomica/{perdidaEconomica}")
    public ResponseEntity<ListMMMVehiculoDTOResponse> findAllVehiculosPerdida(@PathVariable
                                                                                  @NotNull(message = "El valor de la pérdida económica no puede estar vacío")
                                                                                  @DecimalMin(value = "1", message = "La pérdida económica debe ser mayor a cero (0)") Double perdidaEconomica){
        return new ResponseEntity<>(iServiceVehiculo.findAllVehiculosPerdida(perdidaEconomica), HttpStatus.OK);
    }

    @GetMapping("/Vehiculos/perdidaEconomicaTotal/{perdidaEconomica}")
    public ResponseEntity<ListMMMVehiculoTotalDTOResponse> findAllVehiculosPerdidaTotal(@PathVariable
                                                                                            @NotNull(message = "El valor de la pérdida económica no puede estar vacío")
                                                                                            @DecimalMin(value = "1", message = "La pérdida económica debe ser mayor a cero (0)")  Double perdidaEconomica){
        return new ResponseEntity<>(iServiceVehiculo.findAllVehiculosPerdidaTotal(perdidaEconomica), HttpStatus.OK);
    }

}
