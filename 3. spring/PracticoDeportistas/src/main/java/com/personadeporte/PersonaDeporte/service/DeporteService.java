package com.personadeporte.PersonaDeporte.service;

import com.personadeporte.PersonaDeporte.dto.req.DeporteReqDTO;
import com.personadeporte.PersonaDeporte.dto.res.DeporteDTO;
import com.personadeporte.PersonaDeporte.dto.res.DeporteNivelDTO;
import com.personadeporte.PersonaDeporte.entity.Deporte;
import com.personadeporte.PersonaDeporte.persistence.BBDD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DeporteService {

    private BBDD bbdd = new BBDD();

    public void crearDeporte(DeporteReqDTO deporteReqDTO){
        Deporte deporte = new Deporte(deporteReqDTO.getNombre(), deporteReqDTO.getNivel());
        bbdd.crearDeporte(deporte);
    }

    public List<DeporteDTO> findSports(){
        List<DeporteDTO> deporteDTOList = new ArrayList<>();
        Map<Integer,Deporte> deporteMap = bbdd.getDeportes();
        for (Deporte value : deporteMap.values()){
            DeporteDTO dto = new DeporteDTO();
            dto.setNombre(value.getNombre());
            deporteDTOList.add(dto);
        }
        return deporteDTOList;
    }

    public DeporteNivelDTO findSportNivel(String nombre){
        Map<Integer,Deporte> deporteMap = bbdd.getDeportes();
        DeporteNivelDTO dto = new DeporteNivelDTO();

        for (Deporte value : deporteMap.values()){
            if(value.getNombre().equals(nombre)){
                dto.setNivel(value.getNivel());
            }
        }
        return dto;
    }


}
