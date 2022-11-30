package com.bootcamp.be_java_hisp_w18_g06.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

// No utilizamos la clase mapper
public class Mapper {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public <T, G> G convertToDo(T t) {
		TypeReference<G> typeRef = new TypeReference<>() {};
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.convertValue(t, typeRef);
	}
}
