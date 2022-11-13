package com.bootcamp.CarAgency.service.imp;

import com.bootcamp.CarAgency.dto.view.VehicleFullDto;
import com.bootcamp.CarAgency.dto.view.VehicleWithoutServiceDto;
import com.bootcamp.CarAgency.entity.Vehicle;
import com.bootcamp.CarAgency.repository.IVehicleRepository;
import com.bootcamp.CarAgency.service.IVehicleService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;


    private ObjectMapper mapper=new ObjectMapper();


    @Override
    public void saveVehicle(VehicleFullDto vehicle) {
        vehicleRepository.saveVehicle(convertToEntity(vehicle));
    }

    @Override
    public List<VehicleWithoutServiceDto> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::convertToVehicleWithoutServiceDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleFullDto> findByManufacturingDate(String manufacturingDate) {
        return vehicleRepository.findByManufacturingDate(manufacturingDate).stream()
                .map(this::convertToVehicleFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleFullDto> findByPrice(String price) {
        return vehicleRepository.findByPrice(price).stream()
                .map(this::convertToVehicleFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleFullDto findById(Integer id) {
        return convertToVehicleFullDto(vehicleRepository.findById(id));
    }

    private Vehicle convertToEntity(VehicleFullDto vehicleFullDto){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(vehicleFullDto,Vehicle.class);
    }
    private VehicleFullDto convertToVehicleFullDto(Vehicle vehicle){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(vehicle,VehicleFullDto.class);
    }
    private VehicleWithoutServiceDto convertToVehicleWithoutServiceDto(Vehicle vehicle){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(vehicle,VehicleWithoutServiceDto.class);
    }
}
