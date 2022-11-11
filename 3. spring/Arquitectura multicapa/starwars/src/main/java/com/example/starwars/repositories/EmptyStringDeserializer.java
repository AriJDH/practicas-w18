package com.example.starwars.repositories;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;

public class EmptyStringDeserializer extends StdScalarDeserializer<String> {
    public EmptyStringDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        final String val = parser.getValueAsString();

        if ("NA".equalsIgnoreCase(val))
            return null;

        return val;
    }
}