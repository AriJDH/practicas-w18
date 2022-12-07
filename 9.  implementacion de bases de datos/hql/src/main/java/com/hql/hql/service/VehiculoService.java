package com.hql.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hql.hql.dto.AñoDTO;
import com.hql.hql.dto.VehiculoDTO;
import com.hql.hql.dto.VehiculoDTOReq;
import com.hql.hql.entity.Vehiculo;
import com.hql.hql.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public VehiculoDTO createVehiculo(VehiculoDTOReq vehiculoDTOReq) {
        ModelMapper mapper = new ModelMapper();
        Vehiculo obj = vehiculoRepository.save(mapper.map(vehiculoDTOReq, Vehiculo.class));
        return new VehiculoDTO(obj.getId(), obj.getPatente(), obj.getMarca(),
                obj.getModelo(), obj.getAñoFabricacion(), obj.getCantRuedas());
    }

    @Override
    public List<VehiculoDTO> getAllVehiculos() {
        ModelMapper mapper = new ModelMapper();
        return vehiculoRepository.findAll().stream()
                .map(v -> new VehiculoDTO(v.getId(), v.getPatente(), v.getMarca(),
                        v.getModelo(), v.getAñoFabricacion(), v.getCantRuedas()))
                .collect(Collectors.toList());

    }

    @Override
    public List<AñoDTO> findByAñoDeFabricacion() {
        return vehiculoRepository.findByAñoDeFabricacion().stream()
                .map(v -> new AñoDTO(v.getPatente(), v.getMarca()))
                .collect(Collectors.toList());
    }
}
