package com.dh.linktracker.util;

import org.modelmapper.ModelMapper;

public class MapperSingleton {
    private static ModelMapper mapper;

    public static ModelMapper getInstance(){
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

}
