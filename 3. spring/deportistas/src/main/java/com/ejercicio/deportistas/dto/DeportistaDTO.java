package com.ejercicio.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {
    private String nombreCompleto;
    private List<String> deportes;
}
