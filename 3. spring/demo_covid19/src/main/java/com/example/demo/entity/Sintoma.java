package com.example.demo.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
