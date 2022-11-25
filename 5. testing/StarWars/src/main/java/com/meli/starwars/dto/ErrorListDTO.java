package com.meli.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorListDTO {
    private Map<String, String> errors;
}
