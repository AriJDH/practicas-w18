package com.example.covid19.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {
    private Integer codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
