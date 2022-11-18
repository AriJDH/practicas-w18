package com.mercadolibre.blog.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    public final static ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();
}
