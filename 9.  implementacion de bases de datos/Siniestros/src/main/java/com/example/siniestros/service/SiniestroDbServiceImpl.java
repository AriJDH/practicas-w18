package com.example.siniestros.service;

import com.example.siniestros.DTOs.SiniestroDTO;
import com.example.siniestros.DTOs.VehiculoDTO;
import com.example.siniestros.entity.Siniestro;
import com.example.siniestros.entity.Vehiculo;
import com.example.siniestros.repository.SiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroDbServiceImpl implements SiniestroDbService{
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private SiniestroRepository siniestroRepository;
    @Autowired
    private VehiculoDbService vehiculoDbService;

    @Override
    public SiniestroDTO createSiniestro(SiniestroDTO siniestroDTO) {
        Siniestro siniestro = modelMapper.map(siniestroDTO, Siniestro.class);
        Vehiculo vehiculo = vehiculoDbService.findVehiculoById(siniestroDTO.getIdVehiculoDenunciado());
        siniestro.setVehiculoDenunciado(vehiculo);
        siniestroRepository.save(siniestro);
        return siniestroDTO;
    }
}
