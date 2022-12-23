package com.example.seguros.service;

import com.example.seguros.dto.PatentesDTO;
import com.example.seguros.dto.PatentesMarcaDTO;
import com.example.seguros.dto.PatentesMarcaModeloDTO;
import com.example.seguros.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImp implements IVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public PatentesDTO findPatentes() {
        List<String> patentes = vehiculoRepository.listPatentes();
        PatentesDTO patentesDTO = new PatentesDTO(patentes);
        return patentesDTO;
    }

    @Override
    public List<PatentesMarcaDTO> findPatentesMarca() {
        List<String[]> patentesMarca = vehiculoRepository.findPatentesAndMarca();
        List<PatentesMarcaDTO> patentesAndMarca = patentesMarca.stream().map(element ->
                new PatentesMarcaDTO(element[0], element[1]))
                .collect(Collectors.toList());
        return patentesAndMarca;
    }

    @Override
    public PatentesDTO findPatentesByRuedasAndAnio() {
        List<String> patentes = vehiculoRepository.listPatentesOfVehiculos();
        PatentesDTO patentesDTO = new PatentesDTO(patentes);
        return patentesDTO;
    }

    @Override
    public List<PatentesMarcaModeloDTO> listVehiclesBySinisterMount() {
        List<String[]> patentesMarcaModelo = vehiculoRepository.listSinisterMount10000();
        List<PatentesMarcaModeloDTO> patentesMarcaModeloDTO =
                patentesMarcaModelo.stream()
                        .map(element -> new PatentesMarcaModeloDTO(
                                element[0],
                                element[1],
                                element[2])
                        )
                        .collect(Collectors.toList());
        return patentesMarcaModeloDTO;
    }
}
