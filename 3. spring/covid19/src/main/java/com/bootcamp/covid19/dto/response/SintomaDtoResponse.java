package com.bootcamp.covid19.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SintomaDtoResponse {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
