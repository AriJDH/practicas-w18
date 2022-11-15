package com.example.StarsWars.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;

import java.io.IOException;

public class IntegerDeserilizerCustom extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if(jsonParser.getText().equals("NA")
                || jsonParser.getText().contains(",")
                || jsonParser.getText().contains(".")){
            return null;
        }else {
            return Integer.valueOf(jsonParser.getText());
        }
    }
}
