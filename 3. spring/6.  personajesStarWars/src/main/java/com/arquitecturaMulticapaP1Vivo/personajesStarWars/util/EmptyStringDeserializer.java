package com.arquitecturaMulticapaP1Vivo.personajesStarWars.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;

public class EmptyStringDeserializer extends StdScalarDeserializer<String> {
	
	public EmptyStringDeserializer() {
		super(String.class);
	}
	
	// Para pasar a null el valor "NA" que aparece en los objetos del JSON
	@Override
	public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
					throws IOException, JacksonException {
		
		final String val = jsonParser.getValueAsString();
		if ("NA".equalsIgnoreCase(val)) {
			return "0";
		}
		return val;
	}
	
	
}
