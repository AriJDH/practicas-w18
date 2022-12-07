package com.jpa.joyeria.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    public static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //Configurations
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
        return mapper;
    }
      /*      Joya newJoya = joyaRepository.findById(id.intValue()).orElseThrow(()-> new RuntimeException("Joya no encontrada"));
        newJoya.setMaterial(joyaDTOreq.getMaterial());
        newJoya.setNombre(joyaDTOreq.getNombre());
        newJoya.setParticularidad(joyaDTOreq.getParticularidad());
        newJoya.setPeso(joyaDTOreq.getPeso());
        newJoya.setPosee_piedr(joyaDTOreq.getPosee_piedr());
        newJoya.setVentaONo(joyaDTOreq.getVentaONo());*/

}
