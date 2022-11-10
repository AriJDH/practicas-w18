package com.example.demo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
}
