package com.example.demodeportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private String deporte;
}
