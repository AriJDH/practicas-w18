package com.jcundere.ejerciciopractico05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaEntity {

    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

}
