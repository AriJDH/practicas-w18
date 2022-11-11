package com.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
}
