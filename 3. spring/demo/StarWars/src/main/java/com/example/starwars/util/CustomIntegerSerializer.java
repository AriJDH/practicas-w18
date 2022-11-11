package com.example.starwars.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.io.IOException;


public class CustomIntegerSerializer extends StdScalarSerializer<Object> {

    public CustomIntegerSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value instanceof String) {
            try {
                gen.writeNumber(Integer.parseInt(value.toString()));
            } catch (NumberFormatException e) {
                gen.writeNumber(0);
            }
        } else if (value instanceof Integer) {
            gen.writeNumber(((Integer) value));
        }
    }
}
