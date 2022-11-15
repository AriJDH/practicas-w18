package com.dh.blog.util;

import org.modelmapper.ModelMapper;

public class MapperSingleton {
    private static ModelMapper mapper;
    public static ModelMapper getInstance(){
        if(mapper==null){
            mapper = new ModelMapper();
        }
        return mapper;
    }
}
