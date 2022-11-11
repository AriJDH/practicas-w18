package com.example.demo.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
