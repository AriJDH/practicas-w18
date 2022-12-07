package com.example.siniestros.service;

import com.example.siniestros.DTOs.PatenteMarcaDTO;
import com.example.siniestros.DTOs.PatenteMarcaModeloDTO;
import com.example.siniestros.DTOs.PatenteMarcaModeloTotalDTO;
import com.example.siniestros.DTOs.VehiculoDTO;
import com.example.siniestros.entity.Vehiculo;
import com.example.siniestros.exception.EntityNotFoundException;
import com.example.siniestros.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoDbServiceImpl implements VehiculoDbService{
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public VehiculoDTO createVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculoToSave = modelMapper.map(vehiculoDTO, Vehiculo.class);
        return modelMapper.map(vehiculoRepository.save(vehiculoToSave), VehiculoDTO.class);
    }

    @Override
    public VehiculoDTO findVehiculoDTOById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(()->{throw new EntityNotFoundException("El vehículo " + id + " no existe.");});
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    @Override
    public Vehiculo findVehiculoById(Long id) {
        return vehiculoRepository.findById(id).orElseThrow(()->{throw new EntityNotFoundException("El vehículo " + id + " no existe.");});
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteMarcaDTO> findAllPatentesAndMarcas() {
        System.out.println(vehiculoRepository.findAllPatentesAndMarcas().toString());
        return vehiculoRepository.findAllPatentesAndMarcas().stream()
                .map(objectArray-> new PatenteMarcaDTO(objectArray[0], objectArray[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllPatentesVehiculo4Ruedas() {
        return vehiculoRepository.findAllPatentesVehiculo4RuedasPorAnio(LocalDate.now().getYear());
    }

    @Override
    public List<PatenteMarcaModeloDTO> findAllPatenteMarcaModelo() {
        return vehiculoRepository.findAllPatenteMarcaModeloPerdidaMayor10000().stream()
                .map(stringArray-> new PatenteMarcaModeloDTO(stringArray[0],stringArray[1],stringArray[2]))
                .collect(Collectors.toList());
    }

    @Override
    public PatenteMarcaModeloTotalDTO findAllPatenteMarcaModeloPerdidaPerdidaMayor10000TotalGastado() {
        return new PatenteMarcaModeloTotalDTO(findAllPatenteMarcaModelo(), vehiculoRepository.findAllPatenteMarcaModeloPerdidaPerdidaMayor10000TotalGastado());
    }
}
