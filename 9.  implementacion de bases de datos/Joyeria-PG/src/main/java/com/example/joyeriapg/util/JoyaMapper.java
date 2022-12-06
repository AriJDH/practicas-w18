package com.example.joyeriapg.util;

import com.example.joyeriapg.dto.request.JoyaRequest;
import com.example.joyeriapg.dto.response.JoyaResponse;
import com.example.joyeriapg.entity.JoyaEntity;

import java.util.ArrayList;
import java.util.List;

public class JoyaMapper {


    public static JoyaEntity joyaRequest2JoyaEntity(JoyaRequest joyaRequest){
        return new JoyaEntity(null,
                joyaRequest.getNombre(),
                joyaRequest.getMaterial(),
                joyaRequest.getPeso(),
                joyaRequest.getParticularidad(),
                joyaRequest.getPoseePiedra(),
                joyaRequest.getVentaONo());

    }

    public static JoyaResponse joya2JoyaResponse(JoyaEntity joyaEntity){
        return new JoyaResponse(
                joyaEntity.getNombre(),
                joyaEntity.getMaterial(),
                joyaEntity.getPeso(),
                joyaEntity.getParticularidad(),
                joyaEntity.getPoseePiedra(),
                joyaEntity.getVentaONo()
        );
    }

    public static List<JoyaResponse> joyaList2JoyaResponseList(List<JoyaEntity> joyaEntityList){
        List<JoyaResponse> joyaResponseList = new ArrayList<>();
        for (JoyaEntity j: joyaEntityList) {
            joyaResponseList.add(joya2JoyaResponse(j));
        }

        return joyaResponseList;

    }
}
