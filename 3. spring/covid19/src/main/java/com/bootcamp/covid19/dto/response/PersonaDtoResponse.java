package com.bootcamp.covid19.dto.response;

import com.bootcamp.covid19.entity.Sintoma;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class PersonaDtoResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomasPersona;
}
