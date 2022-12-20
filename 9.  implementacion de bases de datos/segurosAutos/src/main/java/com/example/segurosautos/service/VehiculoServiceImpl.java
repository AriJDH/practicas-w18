package com.example.segurosautos.service;

import com.example.segurosautos.dto.VehiculoDto;
import com.example.segurosautos.entity.Vehiculo;
import com.example.segurosautos.entity.model.PatenteModeloMarca;
import com.example.segurosautos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;
    private ModelMapper maper = new ModelMapper();

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void addVehiculo(VehiculoDto vehiculo) {
        Vehiculo vehiculoEntity = maper.map(vehiculo, Vehiculo.class);
        vehiculoRepository.save(vehiculoEntity);
    }

    @Override
    public VehiculoDto getVehiculo(Long id) {
        Vehiculo vehiculoEntity = vehiculoRepository.findById(id).orElse(null);
        VehiculoDto vehiculoRespuesta = maper.map(vehiculoEntity, VehiculoDto.class);
        return vehiculoRespuesta;
    }

    @Override
    public List<String> listarPatentes() {
        return vehiculoRepository.listarPatentes();
    }

    @Override
    public List<PatenteModeloMarca> listarPatenteYMarca() {
        List<PatenteModeloMarca> prueba = vehiculoRepository.listarPatenteYMarca();
        return vehiculoRepository.listarPatenteYMarca();
    }

    @Override
    public List<String> listarPatentesPorRuedasYAnio() {
        Integer anio = LocalDate.now().getYear();
        Integer ruedas = 2;
        return vehiculoRepository.listarPatentesPorRuedasYAnio(ruedas, anio);
    }
}
