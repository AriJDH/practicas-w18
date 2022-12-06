package com.example.lasperlas.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "joya")
public class Joyas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;
}