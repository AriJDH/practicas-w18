package com.example.concesionarioautos.service;

import com.example.concesionarioautos.dto.request.AutoRequestDTO;
import com.example.concesionarioautos.dto.response.AutoResponseDTO;
import com.example.concesionarioautos.dto.response.AutoSoloResponseDTO;
import com.example.concesionarioautos.entity.Auto;
import com.example.concesionarioautos.exception.NotFoundException;
import com.example.concesionarioautos.repository.IAutoRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImp implements IAutoService{

    private ObjectMapper op = new ObjectMapper();
    private final IAutoRepository database;

    public AutoServiceImp(IAutoRepository autoRepository) {
        this.database = autoRepository;
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public AutoResponseDTO add(AutoRequestDTO auto) {
        database.add(op.convertValue(auto, Auto.class));
        return op.convertValue(auto, AutoResponseDTO.class);
    }

    @Override
    public List<AutoSoloResponseDTO> listAll() {
        List<AutoSoloResponseDTO> dtoList;
        dtoList = database.listAll().stream().map(auto-> (op.convertValue(auto, AutoSoloResponseDTO.class))).collect(Collectors.toList());
        if(dtoList.isEmpty()){
            throw new NotFoundException("No existen vehículos registrados");
        }
        return dtoList;
    }

    @Override
    public AutoResponseDTO findById(Long id) {
        Auto auto = database.findById(id);
        if (auto == null){
            throw new NotFoundException("No existe el vehículo con id " + id);
        }
        return op.convertValue(auto, AutoResponseDTO.class);
    }

    @Override
    public List<AutoResponseDTO> findByYear(int since, int to) {
        List<Auto> autoList = database.findByYear(since, to);
        if(autoList.isEmpty()){
            throw new NotFoundException("No existen vehículos registrados entre los años " + since + " y " + to);
        }
        return autoList.stream().map(auto-> op.convertValue(auto, AutoResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AutoResponseDTO> findeByPrice(Double since, Double to) {
        List<Auto> autoList = database.findeByPrice(since, to);
        if(autoList.isEmpty()){
            throw new NotFoundException("No existen vehículos registrados entre los precios $" + since + " y $" + to);
        }
        return autoList.stream().map(auto-> op.convertValue(auto, AutoResponseDTO.class)).collect(Collectors.toList());
    }
}
