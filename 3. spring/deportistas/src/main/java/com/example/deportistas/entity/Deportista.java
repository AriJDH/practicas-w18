package com.example.deportistas.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Deportista {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}
