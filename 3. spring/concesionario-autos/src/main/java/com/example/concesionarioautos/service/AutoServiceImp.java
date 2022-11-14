package com.example.concesionarioautos.service;

import com.example.concesionarioautos.dto.request.AutoRequestDTO;
import com.example.concesionarioautos.dto.response.AutoResponseDTO;
import com.example.concesionarioautos.dto.response.AutoSoloResponseDTO;
import com.example.concesionarioautos.entity.Auto;
import com.example.concesionarioautos.repository.IAutoRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImp implements IAutoService{

    private final IAutoRepository database;

    public AutoServiceImp(IAutoRepository autoRepository) {
        this.database = autoRepository;
    }

    @Override
    public AutoResponseDTO add(AutoRequestDTO auto) {
        database.add(new Auto(database.getNexttId(), auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getServices(), auto.getCountOfOwners()));
        return new AutoResponseDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getServices(), auto.getCountOfOwners());
        //ObjectMapper op = new ObjectMapper();
        //op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //return op.convertValue(auto, AutoResponseDTO.class);
    }

    @Override
    public List<AutoSoloResponseDTO> listAll() {
        return database.listAll().stream().map(auto-> new AutoSoloResponseDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getCountOfOwners())).collect(Collectors.toList());
    }

    @Override
    public AutoResponseDTO findById(Long id) {
        Auto auto = database.findById(id);
        return new AutoResponseDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getServices(), auto.getCountOfOwners());
    }

    @Override
    public List<AutoResponseDTO> findByYear(int since, int to) {
        List<Auto> autoList = database.findByYear(since, to);
        return autoList.stream().map(auto-> new AutoResponseDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getServices(), auto.getCountOfOwners())).collect(Collectors.toList());
    }

    @Override
    public List<AutoResponseDTO> findeByPrice(Double since, Double to) {
        List<Auto> autoList = database.findeByPrice(since, to);
        return autoList.stream().map(auto-> new AutoResponseDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(), auto.getNumberOfKilometers(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getServices(), auto.getCountOfOwners())).collect(Collectors.toList());
    }
}
