package com.jcundere.ejerciciopractico07c.util.mapper;

import com.jcundere.ejerciciopractico07c.dto.request.VehicleRequest;
import com.jcundere.ejerciciopractico07c.dto.response.VehicleResponse;
import com.jcundere.ejerciciopractico07c.entity.VehicleEntity;

import java.util.ArrayList;
import java.util.List;

public class VehicleMapper {

    public static VehicleEntity request2Entity(VehicleRequest request) {

        VehicleEntity entity = new VehicleEntity();
        entity.setBrand(request.getBrand());
        entity.setModel(request.getModel());
        entity.setManufacturingDate(request.getManufacturingDate());
        entity.setNumberOfKilometers(request.getNumberOfKilometers());
        entity.setDoors(request.getDoors());
        entity.setPrice(request.getPrice());
        entity.setCurrency(request.getCurrency());
        entity.setServices(ServiceMapper.requestList2EntityList(request.getServices()));
        entity.setCountOfOwners(request.getCountOfOwners());

        return entity;
    }

    public static VehicleResponse entity2Response(VehicleEntity entity) {

        VehicleResponse response = new VehicleResponse();
        response.setBrand(entity.getBrand());
        response.setModel(entity.getModel());
        response.setManufacturingDate(entity.getManufacturingDate());
        response.setNumberOfKilometers(entity.getNumberOfKilometers());
        response.setDoors(entity.getDoors());
        response.setPrice(entity.getPrice());
        response.setCurrency(entity.getCurrency());
        response.setServices(ServiceMapper.entityList2ResponseList(entity.getServices()));
        response.setCountOfOwners(entity.getCountOfOwners());

        return response;
    }

    public static List<VehicleResponse> entityList2ResponseList(List<VehicleEntity> entityList) {

        List<VehicleResponse> responseList = new ArrayList<>();
        for (VehicleEntity entity : entityList) {
            responseList.add(entity2Response(entity));
        }

        return responseList;
    }

}
