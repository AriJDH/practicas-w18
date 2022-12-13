package com.example.seguros.service;

import com.example.seguros.dto.request.VehiculoDTOReq;
import com.example.seguros.dto.response.VehiculoDTORes;
import com.example.seguros.model.entity.VehiculoSiniestro;

import java.util.List;

public interface IVehiculoService {

    VehiculoDTORes createVehiculo(VehiculoDTOReq vehiculoDTOReq);



    List<VehiculoDTORes> findAllVehiculos();

    List<String[]> findByPatente();

    //List<PatenteAndMarca> findByPatenteAndMarca();

    //List<HashMap<String,String>> findByPatenteAndMarca();

    List<String[]> findByPatenteAndMarca();

    List<String[]> findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022();

    List<String[]> findByPatenteAndMarcaAndModelo();

    List<VehiculoSiniestro> findVehiculoSiniestro();

}
