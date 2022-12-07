package com.example.practicahql.service;

import com.example.practicahql.dto.VehiculoDTO;
import com.example.practicahql.model.Vehiculo;
import com.example.practicahql.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl {
    @Autowired
    private IVehiculoRepository repository;

    private ModelMapper mapper;

    public VehiculoDTO create(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = getMapper().map(vehiculoDTO, Vehiculo.class);
        if(repository.save(vehiculo) == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el vehiculo");

        return vehiculoDTO;
    }
    public List<String> findPatentes() {
        List<String> result = new ArrayList<>();
        result = repository.findPatentes();
        return result;
    }
    public List<String> findPatentesMarca() {
        List<String> result = new ArrayList<>();
        result = repository.findPatentesMarca();
        return result;
    }

    private ModelMapper getMapper(){
        if(mapper == null)
            return mapper = new ModelMapper();

        return mapper;
    }

}
