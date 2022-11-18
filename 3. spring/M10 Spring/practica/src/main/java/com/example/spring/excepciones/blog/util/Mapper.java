package com.example.spring.excepciones.blog.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> Object convertTodo(T t, Class<Object> g){
        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(t, g);
    }
}
