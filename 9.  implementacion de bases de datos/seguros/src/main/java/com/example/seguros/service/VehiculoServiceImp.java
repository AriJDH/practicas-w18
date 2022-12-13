package com.example.seguros.service;

import com.example.seguros.dto.request.VehiculoDTOReq;
import com.example.seguros.dto.response.VehiculoDTORes;
import com.example.seguros.model.Vehiculo;
import com.example.seguros.model.entity.VehiculoSiniestro;
import com.example.seguros.respository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImp implements IVehiculoService {
    IVehiculoRepository vehiculoRepository;

    private ModelMapper mapper;

    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDTORes createVehiculo(VehiculoDTOReq vehiculoDTOReq) {
        Vehiculo vehiculo = getMapper().map(vehiculoDTOReq, Vehiculo.class);
        if (vehiculoRepository.save(vehiculo) == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el vehículo");
        return (getMapper().map(vehiculoRepository.save(vehiculo), VehiculoDTORes.class));
    }

    @Override
    public List<VehiculoDTORes> findAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        List<VehiculoDTORes> vehiculoDTORes = vehiculos.stream().map(vehiculo -> getMapper().map(vehiculo, VehiculoDTORes.class)).collect(Collectors.toList());
        return vehiculoDTORes;
    }

    @Override
    public List<String[]> findByPatente() {
        return vehiculoRepository.findByPatente();
    }

    /*  @Override
    public List<PatenteAndMarca> findByPatenteAndMarca() {
        return vehiculoRepository.findByPatenteAndMarca();
    }*/

    /*@Override
    public List<HashMap<String, String>> findByPatenteAndMarca() {
        return vehiculoRepository.findByPatenteAndMarca();
    }*/

    @Override
    public List<String[]> findByPatenteAndMarca() {
        return vehiculoRepository.findByPatenteAndMarca();
    }

    @Override
    public List<String[]> findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022() {
        return vehiculoRepository.findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022();
    }

    @Override
    public List<String[]> findByPatenteAndMarcaAndModelo() {
        return vehiculoRepository.findByPatenteAndMarcaAndModelo();
    }

    @Override
    public List<VehiculoSiniestro> findVehiculoSiniestro() {
        return vehiculoRepository.findVehiculoSiniestro();
    }

    private ModelMapper getMapper() {
        if (mapper == null)
            return mapper = new ModelMapper();

        return mapper;
    }

}
