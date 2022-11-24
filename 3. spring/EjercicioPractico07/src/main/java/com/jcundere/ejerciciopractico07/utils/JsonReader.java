package com.jcundere.ejerciciopractico07.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcundere.ejerciciopractico07.entity.Food;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    private JsonReader() {
    }

    public static List<Food> readAndParseJson(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            File jsonFile = ResourceUtils.getFile("classpath:" + json);
            return mapper.readValue(jsonFile, new TypeReference<List<Food>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
