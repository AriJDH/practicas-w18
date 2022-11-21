package com.kotor.starwars.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;

public class EmptyStringDeserializer extends StdScalarDeserializer<Integer> {

    public EmptyStringDeserializer() {
        super(Integer.class);
    }

    @Override
    public Integer deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        final String val = parser.getValueAsString();

        if ("NA".equalsIgnoreCase(val))
            return null;

        return Integer.parseInt(val);
    }
}