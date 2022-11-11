package com.example.pr_multicapa_grupal_starwars.utilities;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerStringDeserialize extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if (jsonParser.getText().equals("NA")
                || jsonParser.getText().contains(",")
                || jsonParser.getText().contains(".")) {
            return null;
        } else {
            return Integer.parseInt(jsonParser.getText());
        }
    }
}