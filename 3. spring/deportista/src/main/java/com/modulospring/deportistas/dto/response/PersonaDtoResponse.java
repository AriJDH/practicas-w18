package com.modulospring.deportistas.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.modulospring.deportistas.entity.Deporte;
import lombok.*;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDtoResponse {
    private String nombre;
    private String apellido;
    private List<Deporte> deporteDtoRequestList;
}
