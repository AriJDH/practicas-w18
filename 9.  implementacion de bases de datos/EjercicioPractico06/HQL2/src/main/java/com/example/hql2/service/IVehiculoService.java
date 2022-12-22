package com.example.hql2.service;

import com.example.hql2.dto.response.VehiculoResponse;
import com.example.hql2.dto.response.VehiculoTotalDamageResponse;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoResponse> getAllPatentes();

    List<VehiculoResponse> getAllPatenteAndMarcaOrderByAnioDeFabricacion();

    List<VehiculoResponse> getAllPatenteWhereCantRuedasGreater4AndYearsEqualsTo();

    List<VehiculoResponse> getAllPatenteAndMarcaAndModelWherePerdidaEconomicaEqualsTo10000();

    VehiculoTotalDamageResponse getAllPatenteAndMarcaAndModelAndTotalDamageWherePerdidaEconomicaEqualsTo10000();

}
