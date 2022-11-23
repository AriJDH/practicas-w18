package com.jcundere.ejerciciopractico05.utils.mapper;

import com.jcundere.ejerciciopractico05.DTO.response.SintomaResponse;
import com.jcundere.ejerciciopractico05.entity.SintomaEntity;

import java.util.ArrayList;
import java.util.List;

public class SintomaMapper {

    public static SintomaResponse sintomaEntity2SintomaResponse(SintomaEntity sintomaEntity) {

        SintomaResponse sintomaResponse = new SintomaResponse();
        sintomaResponse.setNombre(sintomaEntity.getNombre());
        sintomaResponse.setNivelDeGravedad(sintomaEntity.getNivelDeGravedad());

        return sintomaResponse;
    }

    public static List<SintomaResponse> sintomaEntityList2SintomaResponseList(List<SintomaEntity> sintomaEntityList) {

        List<SintomaResponse> sintomaResponseList = new ArrayList<>();

        for (SintomaEntity elemento : sintomaEntityList) {
            sintomaResponseList.add(sintomaEntity2SintomaResponse(elemento));
        }

        return sintomaResponseList;
    }

}
