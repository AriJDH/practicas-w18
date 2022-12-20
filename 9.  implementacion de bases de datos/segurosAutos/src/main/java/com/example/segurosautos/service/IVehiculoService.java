package com.example.segurosautos.service;

import com.example.segurosautos.dto.VehiculoDto;
import com.example.segurosautos.entity.model.PatenteModeloMarca;

import java.util.List;

public interface IVehiculoService {

    public void addVehiculo(VehiculoDto vehiculo);
    public VehiculoDto getVehiculo(Long id);
    public List<String> listarPatentes();
    public List<PatenteModeloMarca> listarPatenteYMarca();
    public List<String> listarPatentesPorRuedasYAnio();

}
