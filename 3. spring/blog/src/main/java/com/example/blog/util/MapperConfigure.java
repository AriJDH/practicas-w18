package com.example.blog.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MapperConfigure {
    public static ObjectMapper createObjectMapper(){
        ObjectMapper mapper=new ObjectMapper();
        //Configuraciones
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
        return mapper;
    }

}
