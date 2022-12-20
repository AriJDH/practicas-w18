package com.example.joyeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nro_identificatorio")
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    private Boolean ventaONo;

}
