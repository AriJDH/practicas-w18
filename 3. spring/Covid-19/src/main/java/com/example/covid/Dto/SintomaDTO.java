package com.example.covid.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
    private String mensaje;
}

