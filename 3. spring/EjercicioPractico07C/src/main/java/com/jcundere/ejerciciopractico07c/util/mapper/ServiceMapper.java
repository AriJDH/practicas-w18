package com.jcundere.ejerciciopractico07c.util.mapper;

import com.jcundere.ejerciciopractico07c.dto.request.ServiceRequest;
import com.jcundere.ejerciciopractico07c.dto.response.ServiceResponse;
import com.jcundere.ejerciciopractico07c.entity.ServiceEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceMapper {

    public static ServiceEntity request2Entity (ServiceRequest request) {

        ServiceEntity entity = new ServiceEntity();
        entity.setDate(request.getDate());
        entity.setKilometers(request.getKilometers());
        entity.setDescriptions(request.getDescriptions());

        return entity;
    }

    public static List<ServiceEntity> requestList2EntityList (List<ServiceRequest> requestList) {

        List<ServiceEntity> entityList = new ArrayList<>();
        for (ServiceRequest request : requestList) {
            entityList.add(request2Entity(request));
        }

        return entityList;
    }

    public static ServiceResponse entity2Response (ServiceEntity entity) {

        ServiceResponse response = new ServiceResponse();
        response.setDate(entity.getDate());
        response.setKilometers(entity.getKilometers());
        response.setDescriptions(entity.getDescriptions());

        return response;
    }

    public static List<ServiceResponse> entityList2ResponseList (List<ServiceEntity> entityList) {

        List<ServiceResponse> responseList = new ArrayList<>();
        for (ServiceEntity entity : entityList) {
            responseList.add(entity2Response(entity));
        }

        return responseList;
    }

}
