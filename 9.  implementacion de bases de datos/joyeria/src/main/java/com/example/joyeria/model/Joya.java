package com.example.joyeria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

@Getter @Setter
@Entity
@Table(name="joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;

}
