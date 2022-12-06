package com.meli.joyeriaApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    @Column
    private String nombre;
    @Column
    private String material;
    @Column
    private Double peso;
    @Column
    private String particularidad;
    @Column
    private Boolean posee_piedra;
    @Column
    private Boolean ventaONo;
}
