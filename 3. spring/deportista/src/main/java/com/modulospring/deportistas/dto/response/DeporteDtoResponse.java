package com.modulospring.deportistas.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeporteDtoResponse {
    private String nombre;
    private String nivel;
}
