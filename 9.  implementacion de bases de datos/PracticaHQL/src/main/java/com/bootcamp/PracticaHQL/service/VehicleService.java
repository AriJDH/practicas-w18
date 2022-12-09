package com.bootcamp.PracticaHQL.service;

import com.bootcamp.PracticaHQL.dto.req.VehicleDto;
import com.bootcamp.PracticaHQL.dto.view.VehicleMatriculaMarcaModeloAndTotalPerdidaDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteAndMarcaDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteDto;
import com.bootcamp.PracticaHQL.dto.view.VehiclePatenteMarcaModeloDto;
import com.bootcamp.PracticaHQL.entity.Vehicle;
import com.bootcamp.PracticaHQL.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private  IVehicleRepository repository;

    public VehicleService(IVehicleRepository repository) {
        this.repository = repository;
    }

    private ModelMapper mapper;




    public VehicleDto create(VehicleDto vehicleDto){

        Vehicle vehicle = getMapper().map(vehicleDto,Vehicle.class);

        Vehicle save=repository.save(vehicle);

        if( save.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el vehiculo");

        return vehicleDto;
    }
    public List<VehiclePatenteDto> findAllByPatente(){
        return
                repository.findAllByPatente()
                        .stream()
                        .map(VehiclePatenteDto::new)
                        .collect(Collectors.toList());
    }
    public List<VehiclePatenteAndMarcaDto> findAllByPatenteAndMarca(){
                return repository.findAllByPatenteAndMarca()
                        .stream()
                        .map(s -> new VehiclePatenteAndMarcaDto(s[0],s[1]))
                        .collect(Collectors.toList());

    }
    public List<VehiclePatenteDto> findAllPatenteByRuedasAndAnioFabricacion(){
       return repository.findAllPatenteByRuedas()
               .stream()
               .filter(vehicle -> vehicle.getAnioFabricacion() == LocalDate.now().getYear())
               .map(vehicle -> new VehiclePatenteDto(vehicle.getPatente()))
               .collect(Collectors.toList());

    }

    public List<VehiclePatenteMarcaModeloDto> findByPatenteMarcaModeloBySinister(){
        return repository.findByPatenteMarcaModeloBySinister()
                .stream()
                .map(v -> new VehiclePatenteMarcaModeloDto(v[0],v[1],v[2]))
                .collect(Collectors.toList());

    }
    public VehicleMatriculaMarcaModeloAndTotalPerdidaDto findByPatenteMarcaModeloAndPerdidaBySinister(){
        List<VehiclePatenteMarcaModeloDto>patenteMarcaModeloDtoList= repository.findByPatenteMarcaModeloAndPerdidaBySinister()
                .stream()
                .map(v -> new VehiclePatenteMarcaModeloDto(v[0],v[1],v[2]))
                .collect(Collectors.toList());
        Double sumaTotal=repository
                .findByPatenteMarcaModeloAndPerdidaBySinister()
                .stream()
                .mapToDouble(s-> Double.parseDouble(s[3]))
                .sum();
        return new VehicleMatriculaMarcaModeloAndTotalPerdidaDto(patenteMarcaModeloDtoList,sumaTotal);

    }



    private ModelMapper getMapper(){
        if(this.mapper == null)
            return this.mapper = new ModelMapper();

        return mapper;
    }
}
