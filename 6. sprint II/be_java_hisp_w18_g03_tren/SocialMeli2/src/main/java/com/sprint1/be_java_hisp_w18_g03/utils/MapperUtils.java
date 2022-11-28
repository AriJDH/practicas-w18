package com.sprint1.be_java_hisp_w18_g03.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtils {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getMapper(){
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.findAndRegisterModules();
        }
        return objectMapper;
    }
}
