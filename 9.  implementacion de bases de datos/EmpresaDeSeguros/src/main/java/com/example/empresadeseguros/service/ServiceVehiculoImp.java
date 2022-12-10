package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.VehiculoNewDTORequest;
import com.example.empresadeseguros.dto.response.*;
import com.example.empresadeseguros.entity.Vehiculo;
import com.example.empresadeseguros.repository.IRepositorySiniestro;
import com.example.empresadeseguros.repository.IRepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceVehiculoImp implements IServiceVehiculo{
    private final IRepositoryVehiculo iRepositoryVehiculo;

    public ServiceVehiculoImp(IRepositoryVehiculo iRepositoryVehiculo){
        this.iRepositoryVehiculo = iRepositoryVehiculo;
    }
    @Override
    public PatentesVehiculosDTOResponse findAllVehiculos() {
        List<String> listPatentes = iRepositoryVehiculo.findAllVehiculos().stream().map(x->x.getPatente()).collect(Collectors.toList());
        PatentesVehiculosDTOResponse patentesVehiculosDTOResponse = new PatentesVehiculosDTOResponse();
        patentesVehiculosDTOResponse.setPatente(listPatentes);
        patentesVehiculosDTOResponse.setMensaje("Listado de patentes de vehículos registrados.");
        return patentesVehiculosDTOResponse;
    }

    @Override
    public ListPatMarcaVehiculosDTOResponse findAllVehiculosOrderbyAnio() {
        List<PatMarcaVehiculosDTOResponse> listMarcaPatentes = iRepositoryVehiculo.findAllVehiculosOrderbyAnio()
                .stream()
                .map(x-> new PatMarcaVehiculosDTOResponse(x.getMarca(), x.getPatente()))
                .collect(Collectors.toList());
        ListPatMarcaVehiculosDTOResponse listPatMarcaVehiculosDTOResponse = new ListPatMarcaVehiculosDTOResponse();
        listPatMarcaVehiculosDTOResponse.setPatenteMarca(listMarcaPatentes);
        listPatMarcaVehiculosDTOResponse.setMensaje("Listado de marcas y patentes de vehículos ordenados por año de fabricación.");
        return listPatMarcaVehiculosDTOResponse;
    }

    @Override
    public Integer nuevoVehiculo(VehiculoNewDTORequest vehiculoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        return iRepositoryVehiculo.save(vehiculo).getId();
    }

    @Override
    public VehiculoDTOResponse findById(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(iRepositoryVehiculo.findById(id).orElse(null), VehiculoDTOResponse.class);
    }

    @Override
    public List<VehiculoDTOResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return iRepositoryVehiculo.findAll().stream().map(v -> modelMapper.map(v, VehiculoDTOResponse.class)).collect(Collectors.toList());
    }

    @Override
    public VehiculoConSiniestrosDTOResponse findByIdConSiniestros(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(iRepositoryVehiculo.findById(id).orElse(null), VehiculoConSiniestrosDTOResponse.class ) ;
    }
}

