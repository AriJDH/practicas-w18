package com.example.BE_java_hisp_w18_g04.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    public static ObjectMapper createObjectMapper(){
        ObjectMapper mapper=new ObjectMapper();
        //Configurations
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
        return mapper;
    }
}
