package com.example.deportistas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
