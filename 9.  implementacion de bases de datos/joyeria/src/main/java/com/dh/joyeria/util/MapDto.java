package com.dh.joyeria.util;

import com.dh.joyeria.dto.JoyaDtoRes;
import com.dh.joyeria.entity.Joya;
import org.modelmapper.ModelMapper;

public class MapDto {

    private static ModelMapper mapper;

    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static JoyaDtoRes map(Joya joya){
        return instance().map(joya, JoyaDtoRes.class);
    }

}
