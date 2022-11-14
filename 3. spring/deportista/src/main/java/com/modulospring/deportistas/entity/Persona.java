package com.modulospring.deportistas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deporteList;

}
