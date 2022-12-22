package com.example.joyeria.util.mapper;

import com.example.joyeria.dto.request.JoyaRequest;
import com.example.joyeria.dto.response.JoyaResponse;
import com.example.joyeria.entity.JoyaEntity;

import java.util.ArrayList;
import java.util.List;

public class JoyaMapper {

    public static JoyaEntity request2Entity(JoyaRequest request) {

        JoyaEntity entity = new JoyaEntity();
        entity.setNombre(request.getNombre());
        entity.setMaterial(request.getMaterial());
        entity.setPeso(request.getPeso());
        entity.setParticularidad(request.getParticularidad());
        entity.setPoseePiedra(request.getPoseePiedra());
        entity.setVentaONo(request.getVentaONo());

        return entity;
    }

    public static JoyaResponse entity2Response(JoyaEntity entity) {

        JoyaResponse response = new JoyaResponse();
        response.setNombre(entity.getNombre());
        response.setMaterial(entity.getMaterial());
        response.setPeso(entity.getPeso());
        response.setParticularidad(entity.getParticularidad());
        response.setPoseePiedra(entity.getPoseePiedra());

        return response;
    }

    public static List<JoyaResponse> entityList2ResponseList(List<JoyaEntity> entityList) {

        List<JoyaResponse> responseList = new ArrayList<>();

        for (JoyaEntity entity : entityList) {
            responseList.add(entity2Response(entity));
        }

        return responseList;
    }

}
