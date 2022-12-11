package com.example.hqlvehiculos.service;

import com.example.hqlvehiculos.DTO.SiniestroDto;
import com.example.hqlvehiculos.DTO.VehiculoDto;
import com.example.hqlvehiculos.model.Siniestro;
import com.example.hqlvehiculos.model.Vehiculo;
import com.example.hqlvehiculos.respository.IRepositorySiniestro;
import com.example.hqlvehiculos.respository.IRepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImp {
    @Autowired
    private IRepositoryVehiculo repositoryVehiculo;

    private ModelMapper mapper;

    public VehiculoDto create(VehiculoDto vehicleDto) {
        Vehiculo vehiculo = getMapper().map(vehicleDto, Vehiculo.class);
        repositoryVehiculo.save(vehiculo);
        return vehicleDto;
    }

    private ModelMapper getMapper() {
        if (mapper == null)
            return mapper = new ModelMapper();

        return mapper;
    }

    public List<String> findPatentes() {
        List<String> result = repositoryVehiculo.findPatentes();
        return result;
    }

    public List<String> findPatentesMarca() {
        List<String> result = repositoryVehiculo.findPatentesMarca();
        return result;
    }

    public List<String> getPatentesRuedas() {
        List<String> result = repositoryVehiculo.findPatentesRuedas();
        return result;
    }

    public List<String> getPatenteMarcaModeloSiniestro() {
        List<String> result = repositoryVehiculo.findPatenteMarcaModeloPerdida();
        return result;
    }

    public Vehiculo findVehicleById(Long idVehiculoDenunciado) {
        Vehiculo result = repositoryVehiculo.findVehicleById(idVehiculoDenunciado);
        return result;
    }
}
