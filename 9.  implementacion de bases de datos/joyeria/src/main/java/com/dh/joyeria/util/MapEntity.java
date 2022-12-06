package com.dh.joyeria.util;


import com.dh.joyeria.dto.JoyaDtoReq;
import com.dh.joyeria.entity.Joya;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;

public class MapEntity {

    private static ModelMapper mapper;

    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static Joya map(JoyaDtoReq joyaDto){
        return instance().map(joyaDto, Joya.class);
    }


}
