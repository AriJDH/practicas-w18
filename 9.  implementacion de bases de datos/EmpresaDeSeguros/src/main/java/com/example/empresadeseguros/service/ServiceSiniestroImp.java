package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.SiniestroNewDTORequest;
import com.example.empresadeseguros.dto.response.SiniestroDTOResponse;
import com.example.empresadeseguros.entity.Siniestro;
import com.example.empresadeseguros.entity.Vehiculo;
import com.example.empresadeseguros.exception.NotFoundException;
import com.example.empresadeseguros.repository.IRepositorySiniestro;
import com.example.empresadeseguros.repository.IRepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceSiniestroImp implements IServiceSiniestro{

    private final IRepositorySiniestro iRepositorySiniestro;
    private final IRepositoryVehiculo iRepositoryVehiculo;

    public ServiceSiniestroImp(IRepositorySiniestro iRepositorySiniestro, IRepositoryVehiculo iRepositoryVehiculo){
        this.iRepositorySiniestro = iRepositorySiniestro;
        this.iRepositoryVehiculo = iRepositoryVehiculo;
    }
    @Override
    public Integer nuevoSiniestro(SiniestroNewDTORequest siniestroDTO) {
        ModelMapper modelMapper = new ModelMapper();
        int idVehiculo = siniestroDTO.getVehiculo_id();
        Optional<Vehiculo> vehiculo = iRepositoryVehiculo.findById(idVehiculo);
        if (vehiculo.isEmpty()) throw new NotFoundException("El vehículo con id " + idVehiculo + " no existe.");
        Siniestro siniestro = modelMapper.map(siniestroDTO, Siniestro.class);
        siniestro.setVehiculo(vehiculo.get());
        iRepositorySiniestro.save(siniestro);
        return siniestro.getId() ;
    }

    @Override
    public SiniestroDTOResponse findById(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Siniestro> siniestro = iRepositorySiniestro.findById(id);
        if (siniestro.isEmpty()) throw new NotFoundException("El siniestro con id " + id + " no existe");
        return modelMapper.map(siniestro, SiniestroDTOResponse.class);
    }

    @Override
    public List<SiniestroDTOResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return iRepositorySiniestro.findAll().stream().map(s -> modelMapper.map(s, SiniestroDTOResponse.class)).collect(Collectors.toList());
    }
}
