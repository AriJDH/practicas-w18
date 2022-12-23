package com.example.seguros.service;

import com.example.seguros.dto.PatentesDTO;
import com.example.seguros.dto.PatentesMarcaDTO;
import com.example.seguros.dto.PatentesMarcaModeloDTO;

import java.util.List;

public interface IVehiculoService {
    PatentesDTO findPatentes();
    List<PatentesMarcaDTO> findPatentesMarca();
    PatentesDTO findPatentesByRuedasAndAnio();
    List<PatentesMarcaModeloDTO> listVehiclesBySinisterMount();
}
