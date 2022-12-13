package com.example.empresaseguro.service;

import com.example.empresaseguro.dto.request.VehiculoDTORequest;
import com.example.empresaseguro.dto.response.VehiculoDTOResponse;
import com.example.empresaseguro.model.Vehiculo;
import com.example.empresaseguro.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVehiculoImp implements IServiceVehiculo{
    private final IVehiculoRepository vehiculoRepository;

    public ServiceVehiculoImp(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void crearVehiculo(VehiculoDTORequest vehiculoDTORequest) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPatente(vehiculo.getPatente());
        vehiculo.setIdVehiculo(vehiculo.getIdVehiculo());
        vehiculo.setMarca(vehiculo.getMarca());
        vehiculo.setAnio(vehiculo.getAnio());
        vehiculo.setModelo(vehiculo.getModelo());
        vehiculo.setCantidadRuedas(vehiculo.getCantidadRuedas());


    }

    @Override
    public void findAll() {
        List<Vehiculo> vehicleList = vehiculoRepository.findAll();

    }

    @Override
    public void findById() {

    }

    @Override
    public void findAllPlates() {

    }

    @Override
    public void findAllPlatesBrandOrderedByDate() {

    }

    @Override
    public void findAllPlatesMoreForWheelsAndThisYear() {

    }

    @Override
    public void findAllPlatesBrandModelWith10kLoss() {

    }

    @Override
    public void findAllPlatesBrandModelWith10kLossPlusTotal() {

    }
}
