package com.example.lasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JoyasDto {

    Long id;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;

    @Override
    public String toString() {
        return "Joya: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\nmaterial: " + material +
                "\npeso: " + peso +
                "\nparticularidad: " + particularidad +
                "\nposeePiedra: " + poseePiedra +
                "\nventaONo: " + ventaONo;
    }
}