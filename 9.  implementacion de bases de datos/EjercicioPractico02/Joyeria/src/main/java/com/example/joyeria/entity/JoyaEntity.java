package com.example.joyeria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "joyas")
public class JoyaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentidicatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean poseePiedra;

    private Boolean ventaONo;

}
