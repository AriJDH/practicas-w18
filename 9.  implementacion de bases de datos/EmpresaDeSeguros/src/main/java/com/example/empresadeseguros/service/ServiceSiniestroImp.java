package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.SiniestroNewDTORequest;
import com.example.empresadeseguros.dto.response.SiniestroDTOResponse;
import com.example.empresadeseguros.entity.Siniestro;
import com.example.empresadeseguros.entity.Vehiculo;
import com.example.empresadeseguros.repository.IRepositorySiniestro;
import com.example.empresadeseguros.repository.IRepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Siniestro siniestro = iRepositorySiniestro.save(modelMapper.map(siniestroDTO, Siniestro.class));
        Vehiculo vehiculo = iRepositoryVehiculo.findById(siniestro.getVehiculo_id()).orElse(null);
        //vehiculo.getSiniestros().add(siniestro);
        vehiculo.setSiniestros(Set.of(siniestro));
        return siniestro.getId() ;
    }

    @Override
    public SiniestroDTOResponse findById(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(iRepositorySiniestro.findById(id).orElse(null), SiniestroDTOResponse.class);
    }

    @Override
    public List<SiniestroDTOResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return iRepositorySiniestro.findAll().stream().map(s -> modelMapper.map(s, SiniestroDTOResponse.class)).collect(Collectors.toList());
    }
}
