package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.VehiculoNewDTORequest;
import com.example.empresadeseguros.dto.response.ListPatMarcaVehiculosDTOResponse;
import com.example.empresadeseguros.dto.response.PatentesVehiculosDTOResponse;
import com.example.empresadeseguros.dto.response.VehiculoConSiniestrosDTOResponse;
import com.example.empresadeseguros.dto.response.VehiculoDTOResponse;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IServiceVehiculo {
    PatentesVehiculosDTOResponse findAllVehiculos();
    ListPatMarcaVehiculosDTOResponse findAllVehiculosOrderbyAnio();
    Integer nuevoVehiculo(VehiculoNewDTORequest vehiculoDTO);

    VehiculoDTOResponse findById(Integer id);

    List<VehiculoDTOResponse> findAll();

    VehiculoConSiniestrosDTOResponse findByIdConSiniestros(Integer id);
}
