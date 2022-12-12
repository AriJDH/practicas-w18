package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.VehiculoNewDTORequest;
import com.example.empresadeseguros.dto.response.*;
import com.example.empresadeseguros.entity.Vehiculo;
import com.example.empresadeseguros.entity.model.VehiculoSiniestro;
import com.example.empresadeseguros.exception.NotFoundException;
import com.example.empresadeseguros.repository.IRepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceVehiculoImp implements IServiceVehiculo{
    private final IRepositoryVehiculo iRepositoryVehiculo;

    public ServiceVehiculoImp(IRepositoryVehiculo iRepositoryVehiculo){
        this.iRepositoryVehiculo = iRepositoryVehiculo;
    }
    @Override
    public PatentesVehiculosDTOResponse findAllVehiculos() {
        List<String> listPatentes = iRepositoryVehiculo.findAllVehiculos().stream().map(Vehiculo::getPatente).collect(Collectors.toList());
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
        Optional<Vehiculo> vehiculo = iRepositoryVehiculo.findById(id);
        if(vehiculo.isEmpty()) throw new NotFoundException("El vehículo con id " + id + " no existe.");
        return modelMapper.map(vehiculo, VehiculoDTOResponse.class);
    }

    @Override
    public List<VehiculoDTOResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return iRepositoryVehiculo.findAll().stream().map(v -> modelMapper.map(v, VehiculoDTOResponse.class)).collect(Collectors.toList());
    }

    @Override
    public VehiculoConSiniestrosDTOResponse findByIdConSiniestros(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Vehiculo> vehiculo = iRepositoryVehiculo.findById(id);
        if(vehiculo.isEmpty()) throw new NotFoundException("El vehículo con id " + id + " no existe.");
        return modelMapper.map(vehiculo, VehiculoConSiniestrosDTOResponse.class);
      }

    @Override
    public PatentesVehiculosDTOResponse findAllVehiculos4RuedasCurrentDate() {
        PatentesVehiculosDTOResponse lista = new PatentesVehiculosDTOResponse();
        lista.setMensaje("Listado de patentes de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.");
        lista.setPatente(iRepositoryVehiculo.findAllVehiculos4RuedasCurrentDate().stream().map(Vehiculo::getPatente).collect(Collectors.toList()));
        return lista;
    }

    @Override
    public ListMMMVehiculoDTOResponse findAllVehiculosPerdida(Double perdidaEconomica) {
        ModelMapper modelMapper = new ModelMapper();
        ListMMMVehiculoDTOResponse lista = new ListMMMVehiculoDTOResponse();
        lista.setMensaje("Listado de patente, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de " + perdidaEconomica);
        lista.setVehiculos( iRepositoryVehiculo.findAllVehiculosPerdida(perdidaEconomica).stream().map(x->modelMapper.map(x, MMMVehiculoDTOResponse.class)).collect(Collectors.toList()) );
        return lista;
    }

    @Override
    public ListMMMVehiculoTotalDTOResponse findAllVehiculosPerdidaTotal(Double perdidaEconomica) {
        ModelMapper modelMapper = new ModelMapper();
        ListMMMVehiculoTotalDTOResponse lista = new ListMMMVehiculoTotalDTOResponse();
        lista.setMensaje("Listado de patente, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de " + perdidaEconomica + " y a cuánto ascendió la pérdida total de todos ellos.");
        lista.setVehiculos(iRepositoryVehiculo.findAllVehiculosPerdida(perdidaEconomica).stream().map(x->modelMapper.map(x, MMMVehiculoDTOResponse.class)).collect(Collectors.toList()) );
        lista.setPerdidaTotal(iRepositoryVehiculo.findAllVehiculosPerdidaTotal(perdidaEconomica).stream().mapToDouble(VehiculoSiniestro::getPerdidaEconomica).sum());
        return lista;
    }
}

