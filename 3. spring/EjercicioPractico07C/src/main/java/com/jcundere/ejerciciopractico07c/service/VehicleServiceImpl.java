package com.jcundere.ejerciciopractico07c.service;

import com.jcundere.ejerciciopractico07c.dto.request.VehicleRequest;
import com.jcundere.ejerciciopractico07c.dto.response.VehicleResponse;
import com.jcundere.ejerciciopractico07c.entity.VehicleEntity;
import com.jcundere.ejerciciopractico07c.repository.IVehicleRepository;
import com.jcundere.ejerciciopractico07c.util.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;


    @Override
    public VehicleResponse saveVehicle(VehicleRequest vehicleRequest) {

        VehicleEntity entity = VehicleMapper.request2Entity(vehicleRequest);
        vehicleRepository.saveEntity(entity);

        return VehicleMapper.entity2Response(entity);
    }

    @Override
    public Optional<VehicleResponse> getVehicleById(Integer id) {

        VehicleResponse vehicleResponse = VehicleMapper.entity2Response(vehicleRepository.getEntityById(id).get());
        return Optional.of(vehicleResponse);
    }

    @Override
    public List<VehicleResponse> getAllVehicle() {

        return VehicleMapper.entityList2ResponseList(vehicleRepository.getAllEntity());
    }

    @Override
    public List<VehicleResponse> getAllVehicleByDateRange(String startDate, String endDate) {

        List<VehicleResponse> filteredList = VehicleMapper.entityList2ResponseList(vehicleRepository.getAllEntity());

        if (!startDate.equals("0")) {
            LocalDate start = LocalDate.parse(startDate);
            filteredList = filteredList
                    .stream()
                    .filter(vehicle -> vehicle.getManufacturingDate().isAfter(start))
                    .collect(Collectors.toList());

        }

        if (!endDate.equals("0")) {
            LocalDate finish = LocalDate.parse(endDate);
            filteredList = filteredList
                    .stream()
                    .filter(vehicle -> vehicle.getManufacturingDate().isBefore(finish))
                    .collect(Collectors.toList());
        }

        return filteredList;
    }

    @Override
    public List<VehicleResponse> getAllVehicleByPriceRange(Integer minValue, Integer maxValue) {

        List<VehicleResponse> filteredList = VehicleMapper.entityList2ResponseList(vehicleRepository.getAllEntity());

        if (minValue > 0) {

            filteredList = filteredList
                    .stream()
                    .filter(vehicle -> vehicle.getPrice() >= minValue)
                    .collect(Collectors.toList());
        }

        if (maxValue > minValue && maxValue > 0) {

            filteredList = filteredList
                    .stream()
                    .filter(vehicle -> vehicle.getPrice() <= maxValue)
                    .collect(Collectors.toList());

        }

        return filteredList;
    }

}
