package com.example.siniestros.service;

import com.example.siniestros.DTOs.PatenteMarcaDTO;
import com.example.siniestros.DTOs.PatenteMarcaModeloDTO;
import com.example.siniestros.DTOs.PatenteMarcaModeloTotalDTO;
import com.example.siniestros.DTOs.VehiculoDTO;
import com.example.siniestros.entity.Vehiculo;

import java.util.List;

public interface VehiculoDbService {
    VehiculoDTO createVehiculo(VehiculoDTO vehiculoDTO);
    VehiculoDTO findVehiculoDTOById(Long id);
    Vehiculo findVehiculoById(Long id);
    List<String> findAllPatentes();
    List<PatenteMarcaDTO> findAllPatentesAndMarcas();
    List<String> findAllPatentesVehiculo4Ruedas();
    List<PatenteMarcaModeloDTO> findAllPatenteMarcaModelo();
    PatenteMarcaModeloTotalDTO findAllPatenteMarcaModeloPerdidaPerdidaMayor10000TotalGastado();
}
