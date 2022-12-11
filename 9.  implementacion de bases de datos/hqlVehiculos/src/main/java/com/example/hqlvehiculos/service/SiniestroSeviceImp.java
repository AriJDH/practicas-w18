package com.example.hqlvehiculos.service;

import com.example.hqlvehiculos.DTO.SiniestroDto;
import com.example.hqlvehiculos.model.Siniestro;
import com.example.hqlvehiculos.model.Vehiculo;
import com.example.hqlvehiculos.respository.IRepositorySiniestro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroSeviceImp {
    @Autowired
    private IRepositorySiniestro repositorySiniestro;
    private VehiculoServiceImp vehiculoService;
    ModelMapper mapper;

    public SiniestroDto createSiniestro(SiniestroDto siniestroDto) {
        Siniestro sin = getMapper().map(siniestroDto, Siniestro.class);
        Vehiculo vehicle = vehiculoService.findVehicleById(siniestroDto.getIdVehiculoDenunciado());
        sin.setVehiculoDenunciado(vehicle);
        repositorySiniestro.save(sin);
        return siniestroDto;
    }
    private ModelMapper getMapper() {
        if (mapper == null)
            return mapper = new ModelMapper();

        return mapper;
    }
}
