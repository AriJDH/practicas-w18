package deporte.service;

import deporte.dto.req.DeporteReqDTO;
import deporte.dto.resp.DeporteDTO;
import deporte.entity.Deporte;
import deporte.persistence.BBDD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class DeporteService {

    private BBDD bbdd = new BBDD();

    public void crearDeporte(DeporteReqDTO deporteReqDTO){
        Deporte deporte = new Deporte(deporteReqDTO.getNombre(),deporteReqDTO.getNivel());
        bbdd.crearDeporte(deporte);
    }

    public List<DeporteDTO> findSport(){
        List<DeporteDTO> deporteDTOList = new ArrayList<>();
        Map<Integer,Deporte> deporteMap = bbdd.getDeportes();
        for (Deporte value : deporteMap.values()){
            
        }
    }
}
