package com.jcundere.ejerciciopractico04.mapper;

import com.jcundere.ejerciciopractico04.DTO.request.DeporteRequest;
import com.jcundere.ejerciciopractico04.DTO.response.DeporteResponse;
import com.jcundere.ejerciciopractico04.entity.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteMapper {


    public static List<DeporteResponse> deporteList2DeporteResponseList(List<Deporte> deporteList) {

        List<DeporteResponse> deporteResponseList = new ArrayList<>();

        for (Deporte elemento : deporteList) {
            deporteResponseList.add(DeporteMapper.deporte2DeporteResponse(elemento));
        }

        return deporteResponseList;
    }

    public static DeporteResponse deporte2DeporteResponse(Deporte deporte) {

        DeporteResponse deporteResponse = new DeporteResponse();
        deporteResponse.setNombre(deporte.getNombre());
        deporteResponse.setNivel(deporte.getNivel());

        return deporteResponse;
    }

    public static Deporte deporteResponse2Deporte(DeporteResponse deporteResponse) {

        Deporte deporte = new Deporte();
        deporte.setNombre(deporteResponse.getNombre());
        deporte.setNivel(deporteResponse.getNivel());

        return deporte;
    }


    public static DeporteRequest deporte2DeporteRequest(Deporte deporte) {

        DeporteRequest deporteRequest = new DeporteRequest();
        deporteRequest.setNombre(deporte.getNombre());
        deporteRequest.setNivel(deporte.getNivel());

        return deporteRequest;
    }

    public static Deporte deporteRequest2Deporte(DeporteRequest deporteRequest) {

        Deporte deporte = new Deporte();
        deporte.setNombre(deporteRequest.getNombre());
        deporte.setNivel(deporteRequest.getNivel());

        return deporte;
    }


}
