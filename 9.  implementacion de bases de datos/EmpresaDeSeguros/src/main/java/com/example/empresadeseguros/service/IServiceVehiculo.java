package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.VehiculoNewDTORequest;
import com.example.empresadeseguros.dto.response.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IServiceVehiculo {
    PatentesVehiculosDTOResponse findAllVehiculos();
    ListPatMarcaVehiculosDTOResponse findAllVehiculosOrderbyAnio();
    Integer nuevoVehiculo(VehiculoNewDTORequest vehiculoDTO);

    VehiculoDTOResponse findById(Integer id);

    List<VehiculoDTOResponse> findAll();

    VehiculoConSiniestrosDTOResponse findByIdConSiniestros(Integer id);

    PatentesVehiculosDTOResponse findAllVehiculos4RuedasCurrentDate();

    ListMMMVehiculoDTOResponse findAllVehiculosPerdida(Double perdidaEconomica);

    ListMMMVehiculoTotalDTOResponse findAllVehiculosPerdidaTotal(Double perdidaEconomica);
}
